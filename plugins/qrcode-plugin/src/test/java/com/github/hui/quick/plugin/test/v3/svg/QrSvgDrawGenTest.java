package com.github.hui.quick.plugin.test.v3.svg;

import com.github.hui.quick.plugin.base.awt.ColorUtil;
import com.github.hui.quick.plugin.qrcode.v3.constants.DrawStyle;
import com.github.hui.quick.plugin.qrcode.v3.constants.TxtMode;
import com.github.hui.quick.plugin.qrcode.v3.entity.QrResource;
import com.github.hui.quick.plugin.qrcode.wrapper.QrCodeGenV3;
import com.github.hui.quick.plugin.test.v3.BasicGenTest;
import org.junit.Test;

import java.awt.*;

/**
 * @author YiHui
 * @date 2022/8/23
 */
public class QrSvgDrawGenTest extends BasicGenTest {

    /**
     * 指定信息点资源
     */
    @Test
    public void drawSpecialResource() throws Exception {
        boolean ans = QrCodeGenV3.of(msg)
                .setSize(500)
                .setDrawResource(new QrResource().setSvg(
                        "<symbol id=\"earth\" viewBox=\"0 0 1024 1024\">" +
                                "   <path d=\"M510.2 516.2m-393.2 0a393.2 393.2 0 1 0 786.4 0 393.2 393.2 0 1 0-786.4 0Z\" fill=\"#186FED\" p-id=\"4431\"></path><path d=\"M625.3 729.7c-0.7 3-4.7 11.6-4.7 11.6-3.3 6.9-8.2 13-11.3 20-1 2.3-0.9 4.9-2 7.2-0.6 1.2-1.4 2.1-1.4 2.2-5.2 6.5-5.2 6.5-9.5 7.5-3.9 0.9-5.7-0.5-7.6-3.4-0.7-1-1.4-7.1-1.2-7.8l0.3-0.9c0.3-0.8 1.8-4.8 5.7-8.7 0.7-0.7 2.1-2.1 2.5-3 0.4-0.9 0.1-1.9 0-2.7-0.6-2.4-1-8 1.1-11.6 2.1-3.5 6.1-2.1 9-3.4 2.2-1 2.9-3.5 4.7-4.9 2.2-1.8 5.4-2.1 7.1-4.7 2.1-3.2 2.7-4.8 3-5.7 0.3-1 0.5-1.1 1-1.3 3 2.6 4.2 5.9 3.3 9.6\" fill=\"#F9CC12\" p-id=\"4432\"></path><path d=\"M306.7 835.9c0.1 0 0.1 0.1 0.2 0.2h-0.1c-4.7-2.2-4.7-2.2-5.3-2.5-2.9-1.9-9-5.9-10.2-7.6h0.1s0.1 0 0.1 0.1l15.2 9.8M891.1 591.9l-4.8 22.5c0 0.1-0.1 0.2-0.1 0.3 0-0.9 0.3-1.7 0.4-2.6-0.3 0.6-0.4 1.3-0.7 1.9-0.2-0.5 0.4-2.7 0.4-2.7 0-0.1 3.7-11.9 1.3-13.9-0.5 0.2-0.6 0.8-1 1.2-0.8-0.8 0.6-5.8 0.7-5.8 1-3 0.2-4.5-0.7-5.2 0.9-2.9 1.4-4.4 1.9-5.2 0.1-0.1 0.2-0.2 0.4-0.3 0.3 0.3 0.4 0.6 0.2 3.5-0.5 7.8-0.5 7.8-0.5 8.1 1.2-4.7 1.5-9.6 3.3-14.1 0.7 0.3 1.1 0.7 0.7 3.1l-1.5 9.2M884.4 599.3c-0.1 0.4-0.3 1.2-0.6 1.9-1.5 2.8-1.5 2.7-1.7 2.4-0.1-0.2-0.1-0.5-0.2-0.7-0.1-0.1-0.3-0.1-0.3-0.2 0 0 0-0.2 0.1-0.8 0-0.1 0.8-2.6 2.1-4.3 0.6-0.7 0.7-0.1 0.7 0.3 0.1 0.3 0 0.8-0.1 1.4M886.4 571.4c-0.2 1.7-1.1 3.2-1.3 4.9-0.1 1 0.2 1.9 0.1 2.9-0.1 0.7-0.3 1.5-0.3 2.2v0.5c0 0.7 0 1.5-0.1 2.3-0.1 0.6-0.2 1.6-0.4 1.9-0.5 0-0.4 0.6-0.6 0.9-0.3-0.2-0.4-1-0.3-2.6 0.1-1.8 0.9-3.4 0.9-5.2-0.1-2.7-0.1-2.7 0-3.8 0-0.2 0-0.5 0.1-0.7 0.4-3.1 1.6-4.7 1.6-4.7s0.1-0.1 0.2-0.1c0 0.1 0.2 0.3 0.1 1.5\" fill=\"#F9CC12\" p-id=\"4433\"></path><path d=\"M858.2 612.3c-0.2 3.9-2.1 7.5-2.8 11.3-0.7 4.3 0.1 5.6 0.6 6.4 0.6 0.9 1.3 2 1 4.1-0.3 2-1.9 3.4-2.3 5.4-0.5 2.1-0.4 4.4-0.9 6.5-3.8 18.2-5.9 18.6-6.7 18.8-0.8-0.7-0.1-2.4-1.5-2.5-0.8-0.1-0.8-0.1-1.9 2.2-0.5 1.1-1.1 1.3-1.4 1.3-0.6 0.1-0.8-0.6-1.3-0.6-1-0.1-2 1.4-3 0.4-0.2-0.3-0.5-1.1-0.6-1.9-0.3-2.5 0.8-4.9 0.2-7.4-0.3-1.2-1.3-2.1-1.1-3.4 0-0.1 1.2-7.2 2.1-9.3 0 0 0.7-1.6 2.1-1.6 0.5 0 1 0 1.2-0.6 0-0.1 0.1-0.2 0.1-0.3 0.8-1.7 0.7-3.6 1.5-5.3 0.9-2.1 2.8-3.5 3.4-5.8 0.7-2.5 0.6-5.1 1.5-7.6 0.6-1.7 2.1-2.9 3-4.4 1.7-2.8 1.4-6.2 2.7-9.1 0.4-0.9 0.6-1.3 1-1.6 1.8-1.1 3.2 2.9 3.1 5M287.7 819.2c-52.8-23.4-115.2-84.9-151.6-247.8s81.3-316.2 142.8-358.2L269 231s-12.3 8.8-1.3 17.9c5.8 4.8 2.4 11.5 6.6 11.3 3.9-0.2 9.5-9 13.4-8.3 2.7 0.4 6.2 5.8 7.1 8.4 0.4 1-0.3 3.3 0 4.3 0.5 1.8 4.4 4.4 4.2 6.3-0.3 3.2-6.3 7.6-9.2 9-4.4 2.2-19.5 2.7-19.5 2.7s-22.7 6.4-26.7 14.9-8 17.1-8 17.1 25.4-20.1 35.4-23.5 17.4-3.1 17.2 1.2c-0.2 4.1-16.5 8.7-9.7 13.3 6.8 4.7 13.7 8 8 16.7-5.7 8.7-10.3 9.6-6.8 14.3 3.5 4.7 7.8 10.7-5.5 12-13.3 1.3-26-4-27.3 1.3s-8.7 4-6 11.3c2.7 7.3 4.7 14-4.7 14.7-9.3 0.7-23.8-2-20.9-3.3 2.9-1.3 6.3-7.6 4.8-10-1.9-2.9-9.7-1.9-12.5 6.3-2.8 8.3 0.6 2.5-9.4 16.4-10 13.9-25.2 18.3-31.3 29.2s-4.3 17.5-8.8 18.6c-2.4 0.6-1.1-12.3-5.8-13.2-4.8-0.9-6 14-5.3 18.7 0.7 4.7 7.6 8.2 2 22.8-5.6 14.7-14 31.2-6 39.8 8 8.7 4.2 5.1 12.1 19.1s29.9 45.7 35.3 57.3c5.3 11.6-7.8 16.7 1.8 21.2 9.5 4.4 14.2 3.9 18.2 10.2 4 6.3 7.2 0.8 15.3 14.9 8.2 14 25.8 21.1 27.3 40.1s-4 17.3-2.7 24.7c1.3 7.3 7.3 24.8 3.3 33.1s-14 8.2-9.3 16.2c4.7 8 4.7 19.2 6 25.3 1.4 6 41.8 57.8 37.4 55.9zM371.4 266.2s7.7-3.9 20.8-5.5c13.1-1.6 6.8 3.1 15.5 2.7 8.7-0.4 15-0.5 20.5 2.7s28.4 9.5 16.6 15.8-18.9 3.5-23.7 14.4-5.5 16.4-20.5 16.4-26-3.2-33.1 3.9c-7.1 7.1-15.8 22.9-20.9 13.4-5.1-9.5-9.1-22.1 0-30s27.1-12.9 20.5-23.4c-6.7-10.4 4.3-10.4 4.3-10.4zM446.1 700.3s6.7-6.7 5-13.4c-1.7-6.7-18.9-25.6-17.8-39.5 1.1-13.9 5.6-21.4-2.8-21.3-8.4 0.1-10.6-12-27.8-5.9-17.3 6-40.1 9.9-54-21.2s-16.1-34.5-11.7-45.7c4.5-11.1 9.2-25.6 6.8-37-2.3-11.4 18.8-19.2 29.4-28.1s17.3-8.7 32.3-16.5 6-24.1 19.3-21.3c13.4 2.8 30.7 26.2 33.5 31.1 3.2 5.4 14.5 9.4 18.7 6.9 4.4-2.7 20-18.3 27-21.1 7.5-2.9 4.2 14.4 19.4 16.1 3.4 0.4 12.8-7.1 15.3-5.3 5.5 3.9-7.2 19.2-8 29.7-0.7 8.5 21.1 12.1 23.8 17.2 6 11.9 7.5 22.1 13.9 34.2 12.4 23.3 6.3 28.7 40.2 19.7 34-9-24.7 67.5-24.7 67.5S566.4 657 568 672.6s9.4 34-3.4 39.5c-12.8 5.6-19.5 10.8-18.9 17.9 0.6 7.1-2.2 2.1-11.1 13.8-8.9 11.7 7.8 4.5-11.1 18.9-18.9 14.5-51.8 24.9-56.8 10.2s-37.3-47-20.6-72.6z\" fill=\"#F9CC12\" p-id=\"4434\"></path><path d=\"M884.2 531c0.2-4.4 0.2-8.9 0.2-13.4 0-50.7-10-99.2-28.3-143.6-7.7-22.8-35.7-69.1-55-93.4-15.2-3.1-21.2 20.1-36.4 23.6-18.1 4.2-23.1 2.6-40 6.3-17 3.7-14.1 1.2-27.2 0s-60.2-17.2-39.8 7.2c20.4 24.4-57.7 9.6-56.3 25.3 2.1 25.1 51.3 49 14.2 67.1-14.5 7.1-43.2 27.2 27.8 49.1 9.4 2.9 31.1 28.1 21.6 35.9-9.5 7.7-13.6-6.5-13.6-6.5s-23.5-34.7-39.5-22c-16 12.7-22.4-6.9-41.3 1.4-15.7 6.9-32.1 27.4-27.8 37.1 4.9 10.9 16.7 5 22.1 16.3 4.8 10 13.1 47.5 26.2 50.4 13 2.9 36.1-12.9 43.2 17.5 7 30.3 40.2 36 56.3 29.8 16-6.2 29.1-49.8 29.1-49.8s-2-6.1 18.1-12.9c20.1-6.8 54.4 67.9 58.2 80.9 3.8 13 14-21.7 13-45.1-1-23.4-5.3-10.5 6.8-36.7 12-26.2 23.3 7.8 41.2 29.6 7.5 9.1 13.1 14.4 18.1 16.9 4.7-20.5 7.7-41.6 8.9-63.2-0.5-2.7-0.3-5.2 0.2-7.8z\" fill=\"#F9CC12\" p-id=\"4435\"></path><path d=\"M417.6 438.1s-11 13.1-19 23.9c-8 10.8-45 29.7-51 9.4s-1.3-42.3 7.8-50.3 21.5 5 25.8 0-15.7-26.1-3.2-28c12.5-2 21.5 1 33.5-13s-7-26 6-36 9.9-31 42.9-36 43.1 10.2 62.1 6.6 18-2.6 29-7.6 30.5-7.2 34.2 14.4 2.8 35.6 12.8 42.6 31.9 35 10.5 36-19.9-5.6-19 15.2c0.9 20.8-17.7 5.7 0 27.8s5.6 14.4-12.4 10.2c-18-4.2-37.1-26.8-54.6-11-17.4 15.8-21.3 4.6-29.4 19.7s-16.9 19.1-29.1 9.4c-12.1-9.8-38.9-48.5-46.9-33.3z\" fill=\"#F9CC12\" p-id=\"4436\"></path>" +
                                "</symbol>"))
                .setDrawStyle(DrawStyle.SVG)
                .asFile(prefix + "/draw_01.svg");
        System.out.println(ans);
    }

    /**
     * 指定信息点1，0点资源
     *
     * @throws Exception
     */
    @Test
    public void drawSpecialResourceV2() throws Exception {
        boolean ans = QrCodeGenV3.of(msg)
                .setSize(500)
                .setDetectSpecial(true)
                .newDrawOptions()
                .setRenderResource(
                        // 第一个资源为信息点图 （即二维码中的黑色区域）
                        new QrResource().setSvg(
                                "<symbol id=\"earth\" viewBox=\"0 0 1024 1024\">" +
                                        "   <path d=\"M510.2 516.2m-393.2 0a393.2 393.2 0 1 0 786.4 0 393.2 393.2 0 1 0-786.4 0Z\" fill=\"#186FED\" p-id=\"4431\"></path><path d=\"M625.3 729.7c-0.7 3-4.7 11.6-4.7 11.6-3.3 6.9-8.2 13-11.3 20-1 2.3-0.9 4.9-2 7.2-0.6 1.2-1.4 2.1-1.4 2.2-5.2 6.5-5.2 6.5-9.5 7.5-3.9 0.9-5.7-0.5-7.6-3.4-0.7-1-1.4-7.1-1.2-7.8l0.3-0.9c0.3-0.8 1.8-4.8 5.7-8.7 0.7-0.7 2.1-2.1 2.5-3 0.4-0.9 0.1-1.9 0-2.7-0.6-2.4-1-8 1.1-11.6 2.1-3.5 6.1-2.1 9-3.4 2.2-1 2.9-3.5 4.7-4.9 2.2-1.8 5.4-2.1 7.1-4.7 2.1-3.2 2.7-4.8 3-5.7 0.3-1 0.5-1.1 1-1.3 3 2.6 4.2 5.9 3.3 9.6\" fill=\"#F9CC12\" p-id=\"4432\"></path><path d=\"M306.7 835.9c0.1 0 0.1 0.1 0.2 0.2h-0.1c-4.7-2.2-4.7-2.2-5.3-2.5-2.9-1.9-9-5.9-10.2-7.6h0.1s0.1 0 0.1 0.1l15.2 9.8M891.1 591.9l-4.8 22.5c0 0.1-0.1 0.2-0.1 0.3 0-0.9 0.3-1.7 0.4-2.6-0.3 0.6-0.4 1.3-0.7 1.9-0.2-0.5 0.4-2.7 0.4-2.7 0-0.1 3.7-11.9 1.3-13.9-0.5 0.2-0.6 0.8-1 1.2-0.8-0.8 0.6-5.8 0.7-5.8 1-3 0.2-4.5-0.7-5.2 0.9-2.9 1.4-4.4 1.9-5.2 0.1-0.1 0.2-0.2 0.4-0.3 0.3 0.3 0.4 0.6 0.2 3.5-0.5 7.8-0.5 7.8-0.5 8.1 1.2-4.7 1.5-9.6 3.3-14.1 0.7 0.3 1.1 0.7 0.7 3.1l-1.5 9.2M884.4 599.3c-0.1 0.4-0.3 1.2-0.6 1.9-1.5 2.8-1.5 2.7-1.7 2.4-0.1-0.2-0.1-0.5-0.2-0.7-0.1-0.1-0.3-0.1-0.3-0.2 0 0 0-0.2 0.1-0.8 0-0.1 0.8-2.6 2.1-4.3 0.6-0.7 0.7-0.1 0.7 0.3 0.1 0.3 0 0.8-0.1 1.4M886.4 571.4c-0.2 1.7-1.1 3.2-1.3 4.9-0.1 1 0.2 1.9 0.1 2.9-0.1 0.7-0.3 1.5-0.3 2.2v0.5c0 0.7 0 1.5-0.1 2.3-0.1 0.6-0.2 1.6-0.4 1.9-0.5 0-0.4 0.6-0.6 0.9-0.3-0.2-0.4-1-0.3-2.6 0.1-1.8 0.9-3.4 0.9-5.2-0.1-2.7-0.1-2.7 0-3.8 0-0.2 0-0.5 0.1-0.7 0.4-3.1 1.6-4.7 1.6-4.7s0.1-0.1 0.2-0.1c0 0.1 0.2 0.3 0.1 1.5\" fill=\"#F9CC12\" p-id=\"4433\"></path><path d=\"M858.2 612.3c-0.2 3.9-2.1 7.5-2.8 11.3-0.7 4.3 0.1 5.6 0.6 6.4 0.6 0.9 1.3 2 1 4.1-0.3 2-1.9 3.4-2.3 5.4-0.5 2.1-0.4 4.4-0.9 6.5-3.8 18.2-5.9 18.6-6.7 18.8-0.8-0.7-0.1-2.4-1.5-2.5-0.8-0.1-0.8-0.1-1.9 2.2-0.5 1.1-1.1 1.3-1.4 1.3-0.6 0.1-0.8-0.6-1.3-0.6-1-0.1-2 1.4-3 0.4-0.2-0.3-0.5-1.1-0.6-1.9-0.3-2.5 0.8-4.9 0.2-7.4-0.3-1.2-1.3-2.1-1.1-3.4 0-0.1 1.2-7.2 2.1-9.3 0 0 0.7-1.6 2.1-1.6 0.5 0 1 0 1.2-0.6 0-0.1 0.1-0.2 0.1-0.3 0.8-1.7 0.7-3.6 1.5-5.3 0.9-2.1 2.8-3.5 3.4-5.8 0.7-2.5 0.6-5.1 1.5-7.6 0.6-1.7 2.1-2.9 3-4.4 1.7-2.8 1.4-6.2 2.7-9.1 0.4-0.9 0.6-1.3 1-1.6 1.8-1.1 3.2 2.9 3.1 5M287.7 819.2c-52.8-23.4-115.2-84.9-151.6-247.8s81.3-316.2 142.8-358.2L269 231s-12.3 8.8-1.3 17.9c5.8 4.8 2.4 11.5 6.6 11.3 3.9-0.2 9.5-9 13.4-8.3 2.7 0.4 6.2 5.8 7.1 8.4 0.4 1-0.3 3.3 0 4.3 0.5 1.8 4.4 4.4 4.2 6.3-0.3 3.2-6.3 7.6-9.2 9-4.4 2.2-19.5 2.7-19.5 2.7s-22.7 6.4-26.7 14.9-8 17.1-8 17.1 25.4-20.1 35.4-23.5 17.4-3.1 17.2 1.2c-0.2 4.1-16.5 8.7-9.7 13.3 6.8 4.7 13.7 8 8 16.7-5.7 8.7-10.3 9.6-6.8 14.3 3.5 4.7 7.8 10.7-5.5 12-13.3 1.3-26-4-27.3 1.3s-8.7 4-6 11.3c2.7 7.3 4.7 14-4.7 14.7-9.3 0.7-23.8-2-20.9-3.3 2.9-1.3 6.3-7.6 4.8-10-1.9-2.9-9.7-1.9-12.5 6.3-2.8 8.3 0.6 2.5-9.4 16.4-10 13.9-25.2 18.3-31.3 29.2s-4.3 17.5-8.8 18.6c-2.4 0.6-1.1-12.3-5.8-13.2-4.8-0.9-6 14-5.3 18.7 0.7 4.7 7.6 8.2 2 22.8-5.6 14.7-14 31.2-6 39.8 8 8.7 4.2 5.1 12.1 19.1s29.9 45.7 35.3 57.3c5.3 11.6-7.8 16.7 1.8 21.2 9.5 4.4 14.2 3.9 18.2 10.2 4 6.3 7.2 0.8 15.3 14.9 8.2 14 25.8 21.1 27.3 40.1s-4 17.3-2.7 24.7c1.3 7.3 7.3 24.8 3.3 33.1s-14 8.2-9.3 16.2c4.7 8 4.7 19.2 6 25.3 1.4 6 41.8 57.8 37.4 55.9zM371.4 266.2s7.7-3.9 20.8-5.5c13.1-1.6 6.8 3.1 15.5 2.7 8.7-0.4 15-0.5 20.5 2.7s28.4 9.5 16.6 15.8-18.9 3.5-23.7 14.4-5.5 16.4-20.5 16.4-26-3.2-33.1 3.9c-7.1 7.1-15.8 22.9-20.9 13.4-5.1-9.5-9.1-22.1 0-30s27.1-12.9 20.5-23.4c-6.7-10.4 4.3-10.4 4.3-10.4zM446.1 700.3s6.7-6.7 5-13.4c-1.7-6.7-18.9-25.6-17.8-39.5 1.1-13.9 5.6-21.4-2.8-21.3-8.4 0.1-10.6-12-27.8-5.9-17.3 6-40.1 9.9-54-21.2s-16.1-34.5-11.7-45.7c4.5-11.1 9.2-25.6 6.8-37-2.3-11.4 18.8-19.2 29.4-28.1s17.3-8.7 32.3-16.5 6-24.1 19.3-21.3c13.4 2.8 30.7 26.2 33.5 31.1 3.2 5.4 14.5 9.4 18.7 6.9 4.4-2.7 20-18.3 27-21.1 7.5-2.9 4.2 14.4 19.4 16.1 3.4 0.4 12.8-7.1 15.3-5.3 5.5 3.9-7.2 19.2-8 29.7-0.7 8.5 21.1 12.1 23.8 17.2 6 11.9 7.5 22.1 13.9 34.2 12.4 23.3 6.3 28.7 40.2 19.7 34-9-24.7 67.5-24.7 67.5S566.4 657 568 672.6s9.4 34-3.4 39.5c-12.8 5.6-19.5 10.8-18.9 17.9 0.6 7.1-2.2 2.1-11.1 13.8-8.9 11.7 7.8 4.5-11.1 18.9-18.9 14.5-51.8 24.9-56.8 10.2s-37.3-47-20.6-72.6z\" fill=\"#F9CC12\" p-id=\"4434\"></path><path d=\"M884.2 531c0.2-4.4 0.2-8.9 0.2-13.4 0-50.7-10-99.2-28.3-143.6-7.7-22.8-35.7-69.1-55-93.4-15.2-3.1-21.2 20.1-36.4 23.6-18.1 4.2-23.1 2.6-40 6.3-17 3.7-14.1 1.2-27.2 0s-60.2-17.2-39.8 7.2c20.4 24.4-57.7 9.6-56.3 25.3 2.1 25.1 51.3 49 14.2 67.1-14.5 7.1-43.2 27.2 27.8 49.1 9.4 2.9 31.1 28.1 21.6 35.9-9.5 7.7-13.6-6.5-13.6-6.5s-23.5-34.7-39.5-22c-16 12.7-22.4-6.9-41.3 1.4-15.7 6.9-32.1 27.4-27.8 37.1 4.9 10.9 16.7 5 22.1 16.3 4.8 10 13.1 47.5 26.2 50.4 13 2.9 36.1-12.9 43.2 17.5 7 30.3 40.2 36 56.3 29.8 16-6.2 29.1-49.8 29.1-49.8s-2-6.1 18.1-12.9c20.1-6.8 54.4 67.9 58.2 80.9 3.8 13 14-21.7 13-45.1-1-23.4-5.3-10.5 6.8-36.7 12-26.2 23.3 7.8 41.2 29.6 7.5 9.1 13.1 14.4 18.1 16.9 4.7-20.5 7.7-41.6 8.9-63.2-0.5-2.7-0.3-5.2 0.2-7.8z\" fill=\"#F9CC12\" p-id=\"4435\"></path><path d=\"M417.6 438.1s-11 13.1-19 23.9c-8 10.8-45 29.7-51 9.4s-1.3-42.3 7.8-50.3 21.5 5 25.8 0-15.7-26.1-3.2-28c12.5-2 21.5 1 33.5-13s-7-26 6-36 9.9-31 42.9-36 43.1 10.2 62.1 6.6 18-2.6 29-7.6 30.5-7.2 34.2 14.4 2.8 35.6 12.8 42.6 31.9 35 10.5 36-19.9-5.6-19 15.2c0.9 20.8-17.7 5.7 0 27.8s5.6 14.4-12.4 10.2c-18-4.2-37.1-26.8-54.6-11-17.4 15.8-21.3 4.6-29.4 19.7s-16.9 19.1-29.1 9.4c-12.1-9.8-38.9-48.5-46.9-33.3z\" fill=\"#F9CC12\" p-id=\"4436\"></path>" +
                                        "</symbol>"),
                        // 第二个资源为背景点图 (即二维码中的白色区域)
                        new QrResource().setSvg(
                                "<symbol id=\"bg\" viewBox=\"0 0 1024 1024\" width=\"200\" height=\"200\">" +
                                        "<path d=\"M512 512m-160 0a160 160 0 1 0 320 0 160 160 0 1 0-320 0Z\" fill=\"#eeeeee\" p-id=\"6725\"></path>" +
                                        "</symbol>")).complete()
                .setDrawStyle(DrawStyle.SVG)
                .asFile(prefix + "/draw_02.svg");
        System.out.println(ans);
    }

    /**
     * 多种绘制样式混搭
     *
     * @throws Exception
     */
    @Test
    public void drawSpecialResourceV3() throws Exception {
        boolean ans = QrCodeGenV3.of(msg)
                .setSize(500)
                .setDetectSpecial(true)
                .newDrawOptions()
                .newRenderResource(new QrResource().setDrawStyle(DrawStyle.RECT))
                .addResource(new QrResource().setDrawStyle(DrawStyle.CIRCLE))
                .addResource(new QrResource().setDrawStyle(DrawStyle.TRIANGLE))
                .addResource(new QrResource().setDrawStyle(DrawStyle.STAR))
                .build()
                .over()
                .setDrawStyle(DrawStyle.SVG)
                .complete()
                .asFile(prefix + "/draw_03.svg");
        System.out.println(ans);
    }

    @Test
    public void drawSpecialResourceV4() throws Exception {
        boolean ans = QrCodeGenV3.of(msg)
                .setSize(500)
                .setDetectSpecial(true)
                .newDrawOptions()
                // 1x1 对应的资源信息
                .newRenderResource(new QrResource().setSvg("<symbol id=\"earth\" viewBox=\"0 0 24 24\"><rect x=\"0\" y=\"0\" width=\"24\" height=\"24\" fill=\"#ff0000\"></rect></symbol>"))
                .addResource(new QrResource().setDrawStyle(DrawStyle.STAR))
                .addResource(new QrResource().setDrawStyle(DrawStyle.TRIANGLE))
                .build()
                // 2x2 对应的资源信息
                .createSource(2, 2, new QrResource().setDrawStyle(DrawStyle.CIRCLE).setDrawColor(Color.RED))
                // 指定文字出现最多只出现3次
                .addResource(new QrResource().setDrawStyle(DrawStyle.TXT).setTxtMode(TxtMode.ORDER).setText("小灰灰").setFontStyle(Font.BOLD).setDrawColor(Color.BLUE), 3)
                .build()
                .over()
                .setDrawStyle(DrawStyle.SVG)
                .complete()
                .asFile(prefix + "/draw_04.svg");
        System.out.println(ans);
    }

    @Test
    public void drawSpecialResourceV5() throws Exception {
        boolean ans = QrCodeGenV3.of(msg)
                .setSize(500)
                .setDetectSpecial(true)
                .newDrawOptions()
                .newRenderResource(new QrResource().setDrawStyle(DrawStyle.STAR).setDrawColor(Color.RED))
                .build()
                // 开始设置一个 w x h 区域的资源
                .createSource(3, 3, new QrResource().setSvg(
                        "<symbol id=\"ten\" viewBox=\"0 0 1024 1024\">" +
                                "<path d=\"M128 416h768v192H128z\" fill=\"#ee0000\" p-id=\"2440\"></path>" +
                                "<path d=\"M896 640H128a32 32 0 0 1-32-32v-192a32 32 0 0 1 32-32h768a32 32 0 0 1 32 32v192a32 32 0 0 1-32 32zM160 576h704v-128H160z\" fill=\"#ee0000\" p-id=\"2441\"></path>" +
                                "<path d=\"M416 896V128h192v768z\" fill=\"#ee0000\" p-id=\"2442\"></path>" +
                                "<path d=\"M608 928h-192a32 32 0 0 1-32-32V128a32 32 0 0 1 32-32h192a32 32 0 0 1 32 32v768a32 32 0 0 1-32 32z m-160-64h128V160h-128z\" fill=\"#ee0000\" p-id=\"2443\"></path>" +
                                "</symbol>"))
                // 十字架资源，指定缺省的坐标
                .setMiss("0-0,2-0,0-2,2-2")
                .build()
                .over()
                .setDrawStyle(DrawStyle.SVG)
                .complete()
                .asFile(prefix + "/draw_05.svg");
        System.out.println(ans);
    }

    @Test
    public void drawSpecialResourceV6() throws Exception {
        boolean ans = QrCodeGenV3.of(msg)
                .setSize(500)
                .newDrawOptions()
                .newRenderResource(new QrResource().setDrawStyle(DrawStyle.STAR).setDrawColor(Color.RED))
                .build()
                // 开始设置一个 w x h 区域的资源
                .createSource(3, 3, new QrResource().setSvg(
                        "<symbol id=\"ten\" viewBox=\"0 0 1024 1024\">" +
                                "<path d=\"M128 416h768v192H128z\" fill=\"#ee0000\" p-id=\"2440\"></path>" +
                                "<path d=\"M896 640H128a32 32 0 0 1-32-32v-192a32 32 0 0 1 32-32h768a32 32 0 0 1 32 32v192a32 32 0 0 1-32 32zM160 576h704v-128H160z\" fill=\"#ee0000\" p-id=\"2441\"></path>" +
                                "<path d=\"M416 896V128h192v768z\" fill=\"#ee0000\" p-id=\"2442\"></path>" +
                                "<path d=\"M608 928h-192a32 32 0 0 1-32-32V128a32 32 0 0 1 32-32h192a32 32 0 0 1 32 32v768a32 32 0 0 1-32 32z m-160-64h128V160h-128z\" fill=\"#ee0000\" p-id=\"2443\"></path>" +
                                "</symbol>"))
                .addResource(new QrResource().setSvg(
                        "<symbol id=\"ten2\" viewBox=\"0 0 1024 1024\">" +
                                "<path d=\"M387.84208 408.812665q-1.009414-1.009414-7.065898-9.589433t-13.122382-19.178866-14.131796-20.18828-11.103554-14.636503q-7.065898-10.09414-3.028242-14.131796t10.09414 2.018828q3.028242 3.028242 10.598847 9.084726t16.150624 12.112968 16.150624 12.112968 11.608261 9.084726q15.14121 13.122382 21.197694 7.065898 3.028242-3.028242 8.075312-6.561191t11.103554-5.551777q10.09414-5.04707 12.112968-23.216522 0-2.018828 4.542363-26.244764t9.589433-58.041304 12.112968-73.182514 12.112968-74.696635 9.589433-61.069546 5.551777-31.796541q2.018828-18.169452 8.075312-19.178866t9.084726 19.178866q1.009414 7.065898 4.542363 32.301248t9.084726 60.564839 11.608261 74.191928 10.598847 72.677807 8.075312 56.527183 4.542363 26.749471q2.018828 6.056484 3.028242 12.617675t6.056484 8.580019q10.09414 4.037656 18.169452 10.09414 12.112968 6.056484 19.178866 0 2.018828-1.009414 10.598847-7.570605t19.178866-14.636503 20.18828-15.14121 13.627089-10.09414q8.075312-6.056484 11.103554-5.04707t0 5.04707q-1.009414 3.028242-8.580019 12.617675t-16.150624 20.692987-15.645917 21.197694l-9.084726 14.131796q-9.084726 12.112968-3.028242 18.169452 3.028242 3.028242 5.551777 7.065898t5.551777 10.09414q6.056484 13.122382 30.28242 17.160038 5.04707 1.009414 28.768299 4.037656t57.536597 8.075312 73.182514 10.598847 73.182514 11.103554 57.536597 9.084726 27.758885 3.532949q12.112968 2.018828 10.598847 9.084726t-10.598847 8.075312q-3.028242 1.009414-28.263592 4.542363t-61.069546 9.589433-77.22017 12.617675-77.724877 12.112968-60.564839 9.589433-25.23535 4.037656q-5.04707 1.009414-9.589433 2.523535t-7.570605 6.561191l-6.056484 12.112968q-4.037656 8.075312-7.065898 10.09414-2.018828 3.028242-3.532949 6.561191t3.532949 10.598847q3.028242 4.037656 9.589433 12.617675t14.636503 19.683573 15.645917 20.18828 9.589433 12.112968q5.04707 8.075312 1.514121 9.084726t-9.589433-4.037656q-4.037656-2.018828-13.627089-8.580019t-20.18828-14.636503-20.18828-14.636503-12.617675-8.580019q-8.075312-9.084726-14.131796-3.028242-3.028242 3.028242-7.570605 4.542363t-8.580019 4.542363q-3.028242 2.018828-6.561191 6.056484t-5.551777 13.122382q0 2.018828-3.532949 27.758885t-8.580019 62.583667-12.112968 79.238998-12.112968 80.248412-9.589433 64.602495-4.542363 31.796541q-2.018828 17.160038-7.065898 14.131796t-7.065898-16.150624q-1.009414-5.04707-4.542363-31.291834t-9.589433-64.602495-13.627089-80.753119-13.627089-79.743705-10.09414-62.583667-4.037656-28.263592q-1.009414-14.131796-9.084726-18.169452-10.09414-4.037656-15.14121-8.075312-5.04707-2.018828-11.608261-1.514121t-8.580019 2.523535q-1.009414 1.009414-11.103554 8.580019t-21.702401 15.645917-21.702401 16.150624-13.122382 9.084726q-3.028242 3.028242-9.084726 4.037656t0-7.065898q3.028242-4.037656 11.608261-15.645917t17.664745-24.225936 16.655331-23.216522 10.598847-13.627089q4.037656-5.04707-0.504707-12.112968t-8.580019-14.131796-11.103554-8.075312-14.131796-3.028242q-2.018828-1.009414-25.740057-4.542363t-58.041304-9.084726-73.687221-12.112968-74.696635-11.608261-61.069546-9.589433-30.787127-5.551777q-16.150624-2.018828-20.692987-9.084726t20.692987-10.09414q9.084726-1.009414 36.843611-5.551777t63.593081-9.589433 76.210756-11.103554 74.191928-11.103554 56.527183-8.580019 23.721229-3.532949q5.04707-1.009414 8.580019-1.514121t6.561191-4.542363q2.018828-5.04707 4.542363-9.084726t4.542363-8.075312q6.056484-8.075312 0-14.131796z\" p-id=\"3411\" fill=\"#ee0000\"></path>" +
                                "</symbol>"
                ))
                // 十字架资源，指定缺省的坐标
                .setMiss("0-0,2-0,0-2,2-2")
                .build()
                // 添加红旗的资源，最多只出现3次
                .createSource(1, 2)
                .addResource(new QrResource().setSvg(
                        "<symbol id=\"flag\" viewBox=\"0 0 1024 1024\">" +
                                "<path d=\"M854.016 140.288V583.68s-182.272 80.384-318.976 0-364.544 0-364.544 0V140.288s182.272-80.384 341.504 0c107.008 53.76 342.016 0 342.016 0z\" fill=\"#EFB4BF\" p-id=\"2768\"></path>" +
                                "<path d=\"M885.248 103.936c-7.168-5.632-16.896-7.68-26.112-5.632-64 14.848-248.32 45.056-329.728 2.56-131.584-69.12-274.944-36.352-340.992-14.848V38.4c0-16.896-13.824-30.72-30.72-30.72s-30.72 13.824-30.72 30.72V988.16c0 16.896 13.824 30.72 30.72 30.72s30.72-13.824 30.72-30.72v-362.496c50.176-15.872 226.816-64 334.336 2.048 52.224 32.256 110.08 43.008 163.328 43.008 101.376 0 187.392-38.912 193.024-41.472 10.752-5.12 17.92-16.384 17.92-28.16V128c0-9.216-4.608-18.432-11.776-24.064z m-49.664 477.184c-47.616 17.408-179.712 56.32-281.088-5.632-52.736-32.256-115.712-43.008-176.128-43.008-72.704 0-141.824 15.36-183.808 27.648V149.504c48.128-17.92 185.344-57.344 306.176 6.144 92.16 48.128 259.584 24.576 334.848 10.752v414.72z\" fill=\"#C9062C\" p-id=\"2769\"></path>" +
                                "</symbol>"
                ), 3).setMiss(0, 1)
                .build()
                .over()
                .setDrawStyle(DrawStyle.SVG)
                .complete()
                .newDetectOptions()
                .setSpecial(true)
                .setInColor(ColorUtil.int2color(0xffee0000))
                .setOutColor(ColorUtil.int2color(0xffdd0000))
                .complete()
                .asFile(prefix + "/draw_06.svg");
        System.out.println(ans);
    }

    /**
     * 吃豆人二维码
     *
     * @throws Exception
     */
    @Test
    public void symbolCdr() throws Exception {
        boolean svg = QrCodeGenV3.of(msg).setW(500)
                .newDrawOptions()
                .setDrawStyle(DrawStyle.SVG)
                .newRenderResource(new QrResource().setSvg(" <symbol id=\"symbol_1R\" viewBox=\"0 0 50 50\">\n" +
                        "        <circle cx=\"25\" cy=\"25\" r=\"11.5\" style=\"fill: #F98E00\"/>\n" +
                        "    </symbol>")).addResource(new QrResource().setSvg("<symbol id=\"symbol_1X\" viewBox=\"0 0 50 50\">\n" +
                        "        <path d=\"M42.82,21.81C42.82,11.98,34.84,4,25,4S7.19,11.98,7.19,21.81L5.5,44l8.03-4.37L19.3,46l5.7-6.37L30.7,46  l5.78-6.37L44.5,44L42.82,21.81z M18.46,27.18c-3.18,0-5.76-2.7-5.76-6.03c0-3.33,2.58-6.03,5.76-6.03s5.76,2.7,5.76,6.03  C24.22,24.48,21.64,27.18,18.46,27.18z M31.54,27.18c-3.18,0-5.76-2.7-5.76-6.03c0-3.33,2.58-6.03,5.76-6.03  c3.18,0,5.76,2.7,5.76,6.03C37.3,24.48,34.72,27.18,31.54,27.18z\"\n" +
                        "              style=\"fill: #F98E00\"/>\n" +
                        "        <ellipse cx=\"20.76\" cy=\"22.13\" rx=\"2.02\" ry=\"2.4\" style=\"fill: #555555\"/>\n" +
                        "        <ellipse cx=\"33.51\" cy=\"21.8\" rx=\"2.02\" ry=\"2.4\" style=\"fill: #555555\"/>\n" +
                        "    </symbol>")).addResource(new QrResource().setSvg("<symbol id=\"symbol_1W\" viewBox=\"0 0 50 50\">\n" +
                        "        <path d=\"M42.82,21.81C42.82,11.98,34.84,4,25,4S7.19,11.98,7.19,21.81L5.5,44l8.03-4.37L19.3,46l5.7-6.37L30.7,46  l5.78-6.37L44.5,44L42.82,21.81z M18.46,27.18c-3.18,0-5.76-2.7-5.76-6.03c0-3.33,2.58-6.03,5.76-6.03s5.76,2.7,5.76,6.03  C24.22,24.48,21.64,27.18,18.46,27.18z M31.54,27.18c-3.18,0-5.76-2.7-5.76-6.03c0-3.33,2.58-6.03,5.76-6.03  c3.18,0,5.76,2.7,5.76,6.03C37.3,24.48,34.72,27.18,31.54,27.18z\"\n" +
                        "              style=\"fill: #40C4ED\"/>\n" +
                        "        <ellipse cx=\"18.63\" cy=\"22.66\" rx=\"2.02\" ry=\"2.4\" style=\"fill: #555555\"/>\n" +
                        "        <ellipse cx=\"31.37\" cy=\"22.34\" rx=\"2.02\" ry=\"2.4\" style=\"fill: #555555\"/>\n" +
                        "    </symbol>")).addResource(new QrResource().setSvg("<symbol id=\"symbol_1V\" viewBox=\"0 0 50 50\">\n" +
                        "        <path d=\"M42.82,21.81C42.82,11.98,34.84,4,25,4S7.19,11.98,7.19,21.81L5.5,44l8.03-4.37L19.3,46l5.7-6.37L30.7,46  l5.78-6.37L44.5,44L42.82,21.81z M18.46,27.18c-3.18,0-5.76-2.7-5.76-6.03c0-3.33,2.58-6.03,5.76-6.03s5.76,2.7,5.76,6.03  C24.22,24.48,21.64,27.18,18.46,27.18z M31.54,27.18c-3.18,0-5.76-2.7-5.76-6.03c0-3.33,2.58-6.03,5.76-6.03  c3.18,0,5.76,2.7,5.76,6.03C37.3,24.48,34.72,27.18,31.54,27.18z\"\n" +
                        "              style=\"fill: #7BB72E\"/>\n" +
                        "        <ellipse cx=\"16.63\" cy=\"22.06\" rx=\"2.02\" ry=\"2.4\" style=\"fill: #555555\"/>\n" +
                        "        <ellipse cx=\"29.37\" cy=\"21.74\" rx=\"2.02\" ry=\"2.4\" style=\"fill: #555555\"/>\n" +
                        "    </symbol>")).build()
                .createSource(2, 1, new QrResource().setSvg("<symbol id=\"symbol_1T\" viewBox=\"0 0 100 50\">\n" +
                        "        <line x1=\"17\" y1=\"25\" x2=\"83\" y2=\"25\"\n" +
                        "              style=\"fill: none; stroke: #333333; stroke-width: 20; stroke-linecap: round; stroke-miterlimit: 10\"/>\n" +
                        "    </symbol>")).addResource(new QrResource().setSvg(" <symbol id=\"symbol_1U\" viewBox=\"0 0 100 50\">\n" +
                        "        <circle cx=\"25\" cy=\"25\" r=\"11.5\" style=\"fill: #F98E00\"/>\n" +
                        "        <circle cx=\"75\" cy=\"25\" r=\"11.5\" style=\"fill: #F98E00\"/>\n" +
                        "    </symbol>")).build()
                .createSource(1, 3, new QrResource().setSvg("<symbol id=\"symbol_1S\" viewBox=\"0 0 50 150\">\n" +
                        "    <line x1=\"25\" y1=\"20\" x2=\"25\" y2=\"130\"\n" +
                        "              style=\"fill: none; stroke: #333333; stroke-width: 20; stroke-linecap: round; stroke-miterlimit: 10\"/>\n" +
                        "    </symbol>")).build().over()
                .complete()
                .newDetectOptions()
                .setLt(new QrResource().setSvg("<symbol id=\"detect_lt\" viewBox=\"0 0 49 49\">\n" +
                        "        <path d=\"M45.5,42.34c0,1.75-1.38,3.16-3.08,3.16H6.59c-1.7,0-3.09-1.42-3.09-3.16V6.66c0-1.75,1.38-3.16,3.09-3.16h35.83c1.7,0,3.08,1.42,3.08,3.16V42.34z\"\n" +
                        "              style=\"fill: none; stroke: #333333; stroke-width: 7; stroke-linecap: round; stroke-miterlimit: 10\"/>\n" +
                        "        <path d=\"M35,31c0,2.21-1.79,4-4,4H18c-2.21,0-4-1.79-4-4V18c0-2.21,1.79-4,4-4h13c2.21,0,4,1.79,4,4V31z\"\n" +
                        "              style=\"fill: #333333\"/>\n" +
                        "    </symbol>"))
                .setLd(new QrResource().setSvg("<symbol id=\"detect_ld\" viewBox=\"0 0 49 49\">\n" +
                        "        <path d=\"M45.5,42.34c0,1.75-1.38,3.16-3.08,3.16H6.59c-1.7,0-3.09-1.42-3.09-3.16V6.66c0-1.75,1.38-3.16,3.09-3.16h35.83c1.7,0,3.08,1.42,3.08,3.16V42.34z\"\n" +
                        "              style=\"fill: none; stroke: #333333; stroke-width: 7; stroke-linecap: round; stroke-miterlimit: 10\"/>\n" +
                        "        <path d=\"M35,31c0,2.21-1.79,4-4,4H18c-2.21,0-4-1.79-4-4V18c0-2.21,1.79-4,4-4h13c2.21,0,4,1.79,4,4V31z\"\n" +
                        "              style=\"fill: #333333\"/>\n" +
                        "    </symbol>"))
                .setRt(new QrResource().setSvg(" <symbol id=\"detect_rt\" viewBox=\"0 0 49 49\">\n" +
                        "        <path d=\"M45.5,42.34c0,1.75-1.38,3.16-3.08,3.16H6.59c-1.7,0-3.09-1.42-3.09-3.16V6.66c0-1.75,1.38-3.16,3.09-3.16h35.83c1.7,0,3.08,1.42,3.08,3.16V42.34z\"\n" +
                        "              style=\"fill: none; stroke: #333333; stroke-width: 7; stroke-linecap: round; stroke-miterlimit: 10\"/>\n" +
                        "        <path d=\"M35,31c0,2.21-1.79,4-4,4H18c-2.21,0-4-1.79-4-4V18c0-2.21,1.79-4,4-4h13c2.21,0,4,1.79,4,4V31z\"\n" +
                        "              style=\"fill: #333333\"/>\n" +
                        "    </symbol>")).complete()
                .build()
                .asFile(prefix + "/吃豆人.svg");
        System.out.println(svg);
    }
}