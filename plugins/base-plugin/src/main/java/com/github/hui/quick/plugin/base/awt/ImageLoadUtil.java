package com.github.hui.quick.plugin.base.awt;

import com.github.hui.quick.plugin.base.file.FileReadUtil;
import com.github.hui.quick.plugin.base.gif.GifDecoder;
import net.sf.image4j.codec.ico.ICODecoder;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by yihui on 2018/3/23.
 */
public class ImageLoadUtil {

    /**
     * 根据路径获取图片
     *
     * @param path 本地路径 or 网络地址
     * @return 图片
     * @throws IOException
     */
    public static BufferedImage getImageByPath(String path) throws IOException {
        if (StringUtils.isBlank(path)) {
            return null;
        }

        try (InputStream stream = FileReadUtil.getStreamByFileName(path)) {
            if (path.endsWith("ico")) {
                // 使用 image4j 解析 ICO 文件
                List<BufferedImage> images = ICODecoder.read(stream);
                return images.isEmpty() ? null : images.get(0);
            }
            return ImageIO.read(stream);
        }
    }

    /**
     * 根据路径获取gif图片
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static GifDecoder getGifByPath(String path) throws IOException {
        if (StringUtils.isBlank(path)) {
            return null;
        }

        GifDecoder decoder = new GifDecoder();
        decoder.read(FileReadUtil.getStreamByFileName(path));
        return decoder;
    }
}
