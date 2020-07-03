package com.rm13.cloud.img;

import cn.hutool.core.util.IdUtil;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.stereotype.Controller;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/3
 */
public class ThumbnailatorTest {


    /**
     * 使用 thumbnailator 创建高质量的缩略图。
     * 给图片加水印，可以设置水印的透明度（0%~100%）。
     * 支持缩略图的旋转，大小调整。
     * 图片批量处理。
     *
     * @param args
     */
    public static void main(String[] args) {
        // 原图片地址
        String source = "/static/img/source.png";
        // 水印图片 相对于resource目录
        String watermark = "/static/img/watermark.png";
        // 输出到文件
        String target = "/static/img/".concat(IdUtil.simpleUUID()).concat(".png");
        // 不透明度
        float opacity = 0.25f;

        try {
            // ImageIO读取图片,获取原图文件
            BufferedImage image = ImageIO.read(ThumbnailatorTest.class.getResourceAsStream(source));
            // 输出图片文件
            File file = new File(ThumbnailatorTest.class.getResource("/").getPath().concat(target));
            Thumbnails.of(image)
                    // 设置图片大小
                    .size(image.getWidth(), image.getHeight())
                    // 图片质量（压缩 0.0-1.0）
                    .outputQuality(0.5f)
                    // 加水印 参数：1.水印位置 2.水印图片 3.不透明度0.0-1.0
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(ThumbnailatorTest.class.getResourceAsStream(watermark)), opacity)
                    // 输出到文件
                    .toFile(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
