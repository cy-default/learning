package com.rm13.cloud.ribboncore;

import com.netflix.loadbalancer.Server;
import org.junit.Test;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/20
 */
public class ServerTest {

    @Test
    public void serverTest001(){
        Server server = new Server("www.yourbatman.com", 886);

        System.out.println(server.getId()); // www.yourbatman.com:886
        System.out.println(server.getHost()); // www.yourbatman.com
        System.out.println(server.getPort()); // 886
        System.out.println(server.getHostPort()); // www.yourbatman.com:886
        System.out.println(server.getScheme()); // null

        server.setId("localhost:8080");
        System.out.println(server.getId()); // localhost:8080
        System.out.println(server.getHost()); // localhost
        System.out.println(server.getPort()); // 8080
        System.out.println(server.getHostPort()); // localhost:8080
        System.out.println(server.getScheme()); // null

        server.setId("https://www.baidu.com");
        System.out.println(server.getId()); // www.baidu.com:443
        System.out.println(server.getHost()); // www.baidu.com
        System.out.println(server.getPort()); // 443
        System.out.println(server.getHostPort()); // www.baidu.com:443
        System.out.println(server.getScheme()); // https
    }
}
