package com.rm13.wx.util;

import cn.hutool.core.codec.Base64;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/1
 */
public class JwtUtil {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(URLEncoder.encode("http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLDFcicvYQU2zNbqfsEAkeFBgq2HMc8xPchCFjvALgczbDoPD9sucbHMbZ4danwlA2oZPRw93qOvQRg/132","UTF-8"));

        final String encode = Base64.encode("http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLDFcicvYQU2zNbqfsEAkeFBgq2HMc8xPchCFjvALgczbDoPD9sucbHMbZ4danwlA2oZPRw93qOvQRg/132".getBytes());
        System.out.println(encode);
        System.out.println(encode.length());
    }
}
