package com.rm13.qrcode;

import com.google.common.collect.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

/**
 * 使用google的zxing工具实现 二维码生成和读的工具类
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-08
 */
@Slf4j
public class QRCodeBaseZxingUtil {


    /**
     * 生成二维码并使用Base64编码
     * @param content
     * @throws Exception
     */

    public static String createQRCode(String content) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Map hints = Maps.newHashMap();
        String base64Img = null;

        try{
            // 指定字符编码为'utf-8'
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            //设置二维码四周白色区域的大小(边距)
            hints.put(EncodeHintType.MARGIN,1);
            //设置二维码的容错性(中级)
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            //画二维码
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            //注意此处拿到字节数据
            ImageIO.write(bufferedImage, "png", os);
            //Base64编码
            base64Img = Base64.getEncoder().encodeToString(os.toByteArray());
            base64Img = "data:image/png;base64," + base64Img;
        } catch (Exception e){
            log.error("create qrcode error:{}", e.getMessage());
        }finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return base64Img;
    }
}
