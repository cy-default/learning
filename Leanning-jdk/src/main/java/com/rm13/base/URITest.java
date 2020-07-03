package com.rm13.base;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/18
 */
public class URITest {

    public static void main(String[] args) throws URISyntaxException {
        final URI uri = new URI("http://localhost:8080/dsaf/dsaf");
        System.out.println(uri.getHost());
        System.out.println(uri.getScheme());
        System.out.println(uri.getPort());
        System.out.println(uri.getPath());


    }
}
