package com.rm13.test;

import com.rm13.qrcode.QRCodeBaseHutoolUtil;
import com.rm13.qrcode.QRCodeBaseZxingUtil;
import org.junit.Test;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-08
 */
public class QRcodeTest {

    @Test
    public void qrcode(){
        System.out.println(QRCodeBaseZxingUtil.createQRCode("http://baidu.com"));
        System.out.println(QRCodeBaseHutoolUtil.createQRCode("http://baidu.com"));
    }

}
