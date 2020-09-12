package com.rm13.cloud.qrcode;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.util.Base64Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/11
 */
public class QRCodeTest {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final QrConfig qrConfig = QrConfig.create();
        QrConfig config = new QrConfig(300, 300);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(0);
        config.setErrorCorrection(ErrorCorrectionLevel.H);

        QrCodeUtil.generate("http%3A%2F%2Flocalhost%3A9244%2Fticket%2Fposter_mid.aspx%3Fposter_id%3D130%26poster_channel%3D158%26parentCode%3DLL5rrmwWLXmojiBYVpkDlUsWQFrTMvxJwfst3oA2oMbgDUMW4HVPreggzYIef9PBEzczEznzQw5XzZvD1K7ng2uiPDXT7YKnYb3B9EaztIRGtfhd1o2VDlxQO0xDI4grUD6CUkJidsqh7GDW%2FD3XtGHOHHdgWZCrcLiwZG2W0ZY%3D%26from_openid%3Dotphe04WQFlUMumKgfPiP9_hhWpA%26from_unionId%3DofI3owOUfIuVyWxYkxXWxnN2YDTY%26fromOpenId%3Dotphe04WQFlUMumKgfPiP9_hhWpA%26fromUnionId%3DofI3owOUfIuVyWxYkxXWxnN2YDTY&sourceOpenId=121321&sourceUnionId=12132", config, ImgUtil.IMAGE_TYPE_JPG, outputStream);

        System.out.println(Base64Utils.encodeToString(outputStream.toByteArray()));
        outputStream.close();

    }
}

