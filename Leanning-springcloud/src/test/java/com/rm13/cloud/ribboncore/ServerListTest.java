package com.rm13.cloud.ribboncore;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import org.junit.Test;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/20
 */
public class ServerListTest {


    /**
     * 在Spring Cloud中，脱离eureka使用ribbon的经典配置：
     * <p>
     * #禁用ribbon在eureka里使用
     * ribbon.eureka.enabled=false
     * #配置服务提供者的地址
     * account.ribbon.listOfServers=localhost:8080,localhost:8081
     */


    /**
     * 自定义负载均衡列表
     */
    @Test
    public void serverListTest001() {
        // 准备配置
        IClientConfig config = new DefaultClientConfigImpl();

        config.set(CommonClientConfigKey.ListOfServers, "    www.baidu.com,http://yourbatman.com:8080    ");

        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
        serverList.initWithNiwsConfig(config);
        serverList.getInitialListOfServers().forEach(server -> {
            System.out.println(server.getId());
            System.out.println(server.getHost());
            System.out.println(server.getPort());
            System.out.println(server.getHostPort());
            System.out.println(server.getScheme());
            System.out.println("-----------------------------");
        });
    }

    /**
     * 读取配置文件config.properties中的数据
     */
    @Test
    public void serverListTest002() {
        IClientConfig config = DefaultClientConfigImpl.getClientConfigWithDefaultValues("account");

        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
        serverList.initWithNiwsConfig(config);

        serverList.getInitialListOfServers().forEach(server -> {
            System.out.println(server.getId());
            System.out.println(server.getHost());
            System.out.println(server.getPort());
            System.out.println(server.getHostPort());
            System.out.println(server.getScheme());
            System.out.println("-----------------------------");
        });
    }


    /**
     * 一个小BUG
     */
    @Test
    public void serverListTest003(){
        DefaultClientConfigImpl config = DefaultClientConfigImpl.getEmptyConfig();
        config.loadDefaultValues(); // 注意：这句必须显示调用，否则配置里无值

        ConfigurationBasedServerList serverList = new ConfigurationBasedServerList();
        serverList.initWithNiwsConfig(config);

        serverList.getInitialListOfServers().forEach(server -> {
            System.out.println(server.getId());
            System.out.println(server.getHost());
            System.out.println(server.getPort());
            System.out.println(server.getHostPort());
            System.out.println(server.getScheme());
            System.out.println("-----------------------------");
        });
    }
}
