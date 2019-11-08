package com.rm13.qrcode;

import cn.hutool.extra.qrcode.QrCodeUtil;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

/**
 * 依托与hutool对zxing的封装实现二维码
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-08
 */
public class QRCodeBaseHutoolUtil {


    public static String createQRCode(String content) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        QrCodeUtil.generate(content, 400, 400, "png", os);
        String base64Img = Base64.getEncoder().encodeToString(os.toByteArray());
        base64Img = "data:image/png;base64,"+base64Img;
        return base64Img;
    }
}
