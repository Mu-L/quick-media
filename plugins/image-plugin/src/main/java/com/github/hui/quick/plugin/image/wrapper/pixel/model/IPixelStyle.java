package com.github.hui.quick.plugin.image.wrapper.pixel.model;

import com.github.hui.quick.plugin.image.helper.ImgPixelHelper;
import com.github.hui.quick.plugin.image.wrapper.pixel.ImgPixelOptions;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author yihui
 * @date 21/11/8
 */
public interface IPixelStyle {
    /**
     * true 表示生成的图片进行放大 blockSize 倍，每个像素点的信息都保留
     * false 表示将 blockSize 区间内的像素点，作为一个像素点信息输出到新的图片上
     *
     * @return
     */
    default boolean scaleUp() {
        return false;
    }

    /**
     * 求取多个颜色的平均值
     *
     * @param colors
     * @return
     */
    default Color getAverage(int[] colors) {
        int alpha = 0;
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int color : colors) {
            alpha += (color >> 24) & 0xff;
            red += (color >> 16) & 0xff;;
            green += (color >> 8) & 0xff;;
            blue += (color & 0xff);
        }
        int len = colors.length;
        return calculateColor(alpha, red, green, blue, len);
    }

    /**
     * 计算颜色均值
     *
     * @param red
     * @param green
     * @param blue
     * @param size
     * @return
     */
    default Color calculateColor(int alpha, int red, int green, int blue, int size) {
        Color color = calculateColor(red, green, blue, size);
        alpha = alpha / size;
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    }

    /**
     * 计算颜色均值
     *
     * @param red
     * @param green
     * @param blue
     * @param size
     * @return
     */
    Color calculateColor(int red, int green, int blue, int size);

    /**
     * 图片绘制
     *
     * @param g2d
     * @param options
     * @param x
     * @param y
     */
    default void draw(Graphics2D g2d, ImgPixelOptions options, int x, int y) {
        g2d.fillRect(x, y, options.getBlockSize(), options.getBlockSize());
    }

    /**
     * 渲染
     *
     * @param g2d
     * @param source
     * @param options
     * @param x
     * @param y
     */
    default void render(Graphics2D g2d, BufferedImage source, ImgPixelOptions options, int x, int y) {
        int[] colors = ImgPixelHelper.getPixels(source, x, y, options.getBlockSize(), options.getBlockSize());
        Color avgColor = getAverage(colors);
        g2d.setColor(avgColor);
        draw(g2d, options, x, y);
    }
}
