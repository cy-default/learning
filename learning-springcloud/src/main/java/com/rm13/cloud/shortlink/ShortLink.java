package com.rm13.cloud.shortlink;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 短链接设计
 *
 * @author yuan.chen
 * @link https://javadoop.com/post/url-shortener
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/8/6
 */
public class ShortLink {

    private static final String BASE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * 0: 设计一张表，key10, key62, orign_url; 可以存储id 对应的长链接地址
     * 1: 采用302重定向的方式实现"redirect:"
     * 1: 使用中控ID发射器 生产唯一ID
     * 2: 把10进制整数转换成62进制数
     *
     * @param args
     */
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(time);
        System.out.println(toBase62(time));
        System.out.println(toBase10(toBase62(time)));
    }


    /*
    @GetMapping("/{key}")
    public String lookup(@PathVariable String key) {
        String originalUrl = shortenerService.lookup(key);
        if (StringUtils.isBlank(originalUrl)) {
            // 如果没有找到长链接，跳转到我们的 m 站，这里其实定制一个 404 页面比较好
            return "redirect:https://m.zhongan.com";
        }
        return "redirect:" + originalUrl;
    }
     */

    public static String toBase62(long num) {
        StringBuilder sb = new StringBuilder();
        int targetBase = BASE.length();
        do {
            int i = (int) (num % targetBase);
            sb.append(BASE.charAt(i));
            num /= targetBase;
        } while (num > 0);

        return sb.reverse().toString();
    }

    public static long toBase10(String input) {
        int srcBase = BASE.length();
        long id = 0;
        String r = new StringBuilder(input).reverse().toString();

        for (int i = 0; i < r.length(); i++) {
            int charIndex = BASE.indexOf(r.charAt(i));
            id += charIndex * (long) Math.pow(srcBase, i);
        }

        return id;
    }
}
