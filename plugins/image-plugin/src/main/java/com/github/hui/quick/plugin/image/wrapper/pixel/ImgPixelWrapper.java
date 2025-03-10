package com.github.hui.quick.plugin.image.wrapper.pixel;

import com.github.hui.quick.plugin.base.awt.ColorUtil;
import com.github.hui.quick.plugin.base.awt.GraphicUtil;
import com.github.hui.quick.plugin.base.constants.MediaType;
import com.github.hui.quick.plugin.base.file.FileReadUtil;
import com.github.hui.quick.plugin.base.file.FileWriteUtil;
import com.github.hui.quick.plugin.base.gif.GifDecoder;
import com.github.hui.quick.plugin.base.gif.GifHelper;
import com.github.hui.quick.plugin.base.io.IoUtil;
import com.github.hui.quick.plugin.image.helper.ImgPixelHelper;
import com.github.hui.quick.plugin.image.util.FontUtil;
import com.github.hui.quick.plugin.image.wrapper.pixel.context.PixelContextHolder;
import com.github.hui.quick.plugin.image.wrapper.pixel.model.IPixelStyle;
import com.github.hui.quick.plugin.image.wrapper.pixel.model.PixelStyleEnum;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

import static com.github.hui.quick.plugin.image.util.PredicateUtil.conditionGetOrElse;

/**
 * 图片像素化
 *
 * @author yihui
 * @date 21/11/8
 */
public class ImgPixelWrapper {
    private static final Logger LOG = LoggerFactory.getLogger(ImgPixelWrapper.class);

    private final ImgPixelOptions pixelOptions;

    static {
        ImageIO.scanForPlugins();
    }

    public static Builder build() {
        return new Builder();
    }

    private ImgPixelWrapper(ImgPixelOptions pixelOptions) {
        this.pixelOptions = pixelOptions;
    }

    /**
     * 转成像素图片
     *
     * @return
     */
    public BufferedImage asBufferedImg() {
        if (pixelOptions.getSource() == null) {
            throw new IllegalArgumentException("bufferedImage cannot be null.");
        }

        return parseImg(pixelOptions.getSource()).left;
    }

    /**
     * 转gif
     *
     * @return
     */
    public ByteArrayOutputStream asGif() {
        GifDecoder decoder = pixelOptions.getGifSource();
        if (decoder == null) {
            throw new IllegalArgumentException("gif source img cannot be null.");
        }

        int gifCnt = decoder.getFrameCount();
        // Pair.left 渲染的字符图， Pair.right gif图展示间隔时间
        List<ImmutablePair<BufferedImage, Integer>> renderImgList = new ArrayList<>(gifCnt);
        for (int index = 0; index < gifCnt; index++) {
            ImmutablePair<BufferedImage, PixelContextHolder.ImgPixelChar> pair = parseImg(decoder.getFrame(index));
            renderImgList.add(ImmutablePair.of(pair.left, decoder.getDelay(index)));
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        GifHelper.saveGif(renderImgList, outputStream);
        return outputStream;
    }

    /**
     * 保存到文件
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public boolean asFile(String fileName) throws Exception {
        File file = new File(fileName);
        FileWriteUtil.mkDir(file.getParentFile());

        if (pixelOptions.getGifSource() != null) {
            try (ByteArrayOutputStream output = asGif()) {
                FileOutputStream out = new FileOutputStream(file);
                out.write(output.toByteArray());
                out.flush();
                out.close();
            }
            return true;
        }

        BufferedImage bufferedImage = asBufferedImg();
        if (!ImageIO.write(bufferedImage, pixelOptions.getPicType(), file)) {
            throw new IOException("save pixel render image to: " + fileName + " error!");
        }

        return true;
    }

    /**
     * 图片转字符时，输出字符数组
     *
     * @return
     */
    public List<List<String>> asChars() {
        // 静态图的转换
        if (pixelOptions.getSource() != null) {
            return PixelContextHolder.toPixelChars(parseImg(pixelOptions.getSource()).getRight());
        }

        // gif图的转换
        GifDecoder decoder = pixelOptions.getGifSource();
        int gifCnt = decoder.getFrameCount();
        PixelContextHolder.ImgPixelChar imgPixelChar = null;
        for (int index = 0; index < gifCnt; index++) {
            ImmutablePair<BufferedImage, PixelContextHolder.ImgPixelChar> pair = parseImg(decoder.getFrame(index));
            pair.right.setPre(imgPixelChar);
            imgPixelChar = pair.right;
        }

        return PixelContextHolder.toPixelChars(imgPixelChar);
    }

    public List<ImmutablePair<List<String>, Map<String, Color>>> asCharsWithColor() {
        // 静态图的转换
        if (pixelOptions.getSource() != null) {
            ImmutablePair<BufferedImage, PixelContextHolder.ImgPixelChar> pair = parseImg(pixelOptions.getSource());
            PixelContextHolder.ImgPixelChar pixelChar = pair.right;
            return Collections.singletonList(ImmutablePair.of(pixelChar.toPixelChars(), pixelChar.getCharColorMap()));
        }

        // gif图的转换
        List<ImmutablePair<List<String>, Map<String, Color>>> res = new ArrayList<>();
        GifDecoder decoder = pixelOptions.getGifSource();
        int gifCnt = decoder.getFrameCount();
        for (int index = 0; index < gifCnt; index++) {
            PixelContextHolder.ImgPixelChar pair = parseImg(decoder.getFrame(index)).right;
            res.add(ImmutablePair.of(pair.toPixelChars(), pair.getCharColorMap()));
        }
        return res;
    }

    /**
     * 输出svg图
     *
     * @return
     */
    public List<String> asSvg() {
        List<List<String>> chars = asChars();
        List<String> result = new ArrayList<>(chars.size());

        for (List<String> txt : chars) {
            result.add(ImgPixelHelper.ascii2svg(txt, ColorUtil.color2htmlColor(pixelOptions.getBgColor()),
                    ColorUtil.color2htmlColor(pixelOptions.getFontColor())));
        }
        return result;
    }

    /**
     * 输出svg文件
     *
     * @param file
     * @throws Exception
     */
    public void asSvgFile(String file) throws Exception {
        FileWriteUtil.FileInfo fileInfo = FileWriteUtil.saveFile(file, "svg");

        List<String> context = asSvg();
        if (context.size() == 1) {
            FileWriteUtil.saveContent(fileInfo, context.get(0));
            return;
        }

        String lastName = fileInfo.getFilename();
        for (int i = 0; i < context.size(); i++) {
            fileInfo.setFilename(lastName + i);
            FileWriteUtil.saveFile(fileInfo, context.get(i));
        }
    }

    /**
     * 解析图像并根据像素选项返回处理后的图像和像素字符信息
     * 此方法负责将源图像按照指定的像素风格和选项进行处理，如果需要放大像素，则调用专门的方法进行处理
     *
     * @param source 源图像，基于此图像进行解析和处理
     * @return 包含处理后图像和像素字符信息的对
     */
    private ImmutablePair<BufferedImage, PixelContextHolder.ImgPixelChar> parseImg(BufferedImage source) {
        // 检查是否需要放大像素，如果是，则调用专门的方法进行处理
        if (pixelOptions.getPixelType().scaleUp()) {
            return parseAndScaleImg(source);
        }

        try {
            // 初始化新的像素字符上下文
            PixelContextHolder.newPic();

            // 检查是否需要缩放图像，如果需要，则进行缩放处理
            if (pixelOptions.getRate() != 1) {
                source = GraphicUtil.scaleImg((int) (source.getWidth() * pixelOptions.getRate()), (int) (source.getHeight() * pixelOptions.getRate()), source);
            }

            int picWidth = source.getWidth();
            int picHeight = source.getHeight();
            int blockSize = pixelOptions.getBlockSize();
            IPixelStyle pixelType = pixelOptions.getPixelType();

            // 创建一个新的图像，用于绘制处理后的像素效果
            BufferedImage pixelImg = new BufferedImage(picWidth / blockSize * blockSize, picHeight / blockSize * blockSize, source.getType());
            Graphics2D g2d = GraphicUtil.getG2d(pixelImg);
            g2d.setColor(null);
            g2d.fillRect(0, 0, picWidth, picHeight);

            // 遍历图像的每个像素块，并使用指定的像素风格进行绘制
            for (int y = 0; y < picHeight; y += blockSize) {
                for (int x = 0; x < picWidth; x += blockSize) {
                    pixelType.render(g2d, source, pixelOptions, x, y);
                }
            }

            // 释放图形资源
            g2d.dispose();

            // 返回处理后的图像和像素字符信息
            return ImmutablePair.of(pixelImg, PixelContextHolder.getPixelChar());
        } finally {
            // 清理像素字符上下文
            PixelContextHolder.clear();
        }
    }

    /**
     * 解析并缩放图像
     * 该方法将源图像解析为像素风格的图像，并按指定的块大小进行缩放
     *
     * @param source 源图像，将基于此图像进行解析和缩放
     * @return 返回一个ImmutablePair对象，包含处理后的图像和像素字符信息
     */
    private ImmutablePair<BufferedImage, PixelContextHolder.ImgPixelChar> parseAndScaleImg(BufferedImage source) {
        try {
            // 初始化一个新的像素字符上下文
            PixelContextHolder.newPic();

            // 获取块大小，用于计算输出图像的尺寸
            int blockSize = pixelOptions.getBlockSize();
            int outWidth = source.getWidth() * blockSize;
            int outHeight = source.getHeight() * blockSize;

            // 获取像素风格接口实现
            IPixelStyle pixelType = pixelOptions.getPixelType();

            // 创建一个新的BufferedImage对象，用于绘制像素风格的图像
            BufferedImage pixelImg = new BufferedImage(outWidth, outHeight, source.getType());

            // 获取Graphics2D对象，用于绘制
            Graphics2D g2d = GraphicUtil.getG2d(pixelImg);

            // 设置绘制颜色为透明，以填充整个图像区域
            g2d.setColor(null);
            g2d.fillRect(0, 0, outWidth, outHeight);

            // 遍历源图像的每个像素，并使用指定的像素风格进行绘制
            for (int y = 0; y < source.getHeight(); y += 1) {
                for (int x = 0; x < source.getWidth(); x += 1) {
                    pixelType.render(g2d, source, pixelOptions, x, y);
                }
            }

            // 释放Graphics2D资源
            g2d.dispose();

            // 返回处理后的图像和像素字符信息
            return ImmutablePair.of(pixelImg, PixelContextHolder.getPixelChar());

        } finally {
            // 清理像素字符上下文
            PixelContextHolder.clear();
        }
    }

    public static class Builder {
        private static final String DEFAULT_CHAR_SET = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\\\"^`'. ";
        private static final double DEFAULT_RATE = 1D;
        private static final int DEFAULT_BLOCK_SIZE = 1;
        private final ImgPixelOptions pixelOptions;

        private String fontName;
        private int fontStyle;

        private Builder() {
            pixelOptions = new ImgPixelOptions();
        }

        /**
         * 设置原始图， 支持gif/jpeg/png
         *
         * @param img
         * @return
         */
        public Builder setSourceImg(String img) {
            try {
                return setSourceImg(FileReadUtil.getStreamByFileName(img));
            } catch (IOException e) {
                throw new RuntimeException("failed to load " + img, e);
            }
        }

        /**
         * 设置原始图， 支持jpeg/png
         *
         * @param img
         * @return
         */
        public Builder setSourceImg(BufferedImage img) {
            pixelOptions.setSource(img);
            return this;
        }

        public Builder setSourceImg(InputStream inputStream) {
            try (ByteArrayInputStream target = IoUtil.toByteArrayInputStream(inputStream)) {
                MediaType media = MediaType.typeOfMagicNum(FileReadUtil.getMagicNum(target));
                if (media != null) {
                    pixelOptions.setPicType(media.getExt());
                }
                if (media == MediaType.ImageGif) {
                    GifDecoder gifDecoder = new GifDecoder();
                    gifDecoder.read(target);
                    pixelOptions.setGifSource(gifDecoder);
                } else {
                    pixelOptions.setSource(ImageIO.read(target));
                }
            } catch (IOException e) {
                LOG.error("load backgroundImg error!", e);
                throw new RuntimeException("load sourceImg error!", e);
            }
            return this;
        }

        public Builder setBlockSize(int size) {
            pixelOptions.setBlockSize(size);
            return this;
        }

        /**
         * 设置像素模式： 灰度 + 像素化 + 字符化
         *
         * @param pixelType
         * @return
         */
        public Builder setPixelType(IPixelStyle pixelType) {
            pixelOptions.setPixelType(pixelType);
            return this;
        }

        /**
         * 设置字符图片的字符集
         *
         * @param chars
         * @return
         */
        public Builder setChars(String chars) {
            pixelOptions.setChars(chars);
            return this;
        }

        /**
         * 设置背景字符
         *
         * @param bgChar
         * @return
         */
        public Builder setBgChar(Character bgChar) {
            pixelOptions.setBgChar(bgChar);
            return this;
        }

        /**
         * 设置缩放比例
         *
         * @param rate
         * @return
         */
        public Builder setRate(Double rate) {
            pixelOptions.setRate(rate);
            return this;
        }


        public Builder setFontName(String fontName) {
            this.fontName = fontName;
            return this;
        }

        public Builder setFontStyle(int fontStyle) {
            this.fontStyle = fontStyle;
            return this;
        }

        public Builder setPicType(String picType) {
            pixelOptions.setPicType(picType);
            return this;
        }

        public Builder setBgColor(int color) {
            pixelOptions.setBgColor(ColorUtil.int2color(color));
            return this;
        }

        public Builder setBgColor(Color color) {
            pixelOptions.setBgColor(color);
            return this;
        }

        public Builder setFontColor(int color) {
            pixelOptions.setFontColor(ColorUtil.int2color(color));
            return this;
        }

        public Builder setFontColor(Color color) {
            pixelOptions.setFontColor(color);
            return this;
        }

        public Builder setFontSize(int fontSize) {
            pixelOptions.setFontSize(fontSize);
            return this;
        }

        public Builder setBgPredicate(Predicate<Integer> predicate) {
            pixelOptions.setBgPredicate(predicate);
            return this;
        }

        public Builder setCharSeparate(Character charSeparate) {
            pixelOptions.setCharSeparate(charSeparate);
            return this;
        }

        public Builder setSameColorThreshold(float sameColorThreshold) {
            pixelOptions.setSameColorThreshold(sameColorThreshold);
            return this;
        }

        public ImgPixelWrapper build() {
            pixelOptions.setBlockSize(conditionGetOrElse((s) -> s > 0, pixelOptions.getBlockSize(), DEFAULT_BLOCK_SIZE));
            pixelOptions.setPixelType(conditionGetOrElse(Objects::nonNull, pixelOptions.getPixelType(), PixelStyleEnum.CHAR_COLOR));
            pixelOptions.setChars(conditionGetOrElse(Objects::nonNull, pixelOptions.getChars(), DEFAULT_CHAR_SET));
            pixelOptions.setRate(conditionGetOrElse(Objects::nonNull, pixelOptions.getRate(), DEFAULT_RATE));
            pixelOptions.setBgColor(conditionGetOrElse(Objects::nonNull, pixelOptions.getBgColor(), Color.WHITE));
            // 默认将全透明作为背景色
            pixelOptions.setBgPredicate(conditionGetOrElse(Objects::nonNull, pixelOptions.getBgPredicate(), integer -> integer == 0));
            pixelOptions.setFontColor(conditionGetOrElse(Objects::nonNull, pixelOptions.getFontColor(), Color.BLACK));
            pixelOptions.setFontSize(conditionGetOrElse(s -> pixelOptions.getFontSize() > 0, Math.min(pixelOptions.getFontSize(), pixelOptions.getBlockSize()), pixelOptions.getBlockSize()));
            fontStyle = conditionGetOrElse((s) -> s >= 0 && s <= 3, fontStyle, Font.PLAIN);
            pixelOptions.setFont(FontUtil.getFontOrDefault(fontName, fontStyle, pixelOptions.getFontSize()));
            pixelOptions.setPicType(conditionGetOrElse(Objects::nonNull, pixelOptions.getPicType(), MediaType.ImageJpg.getExt()));
            return new ImgPixelWrapper(pixelOptions);
        }
    }
}
