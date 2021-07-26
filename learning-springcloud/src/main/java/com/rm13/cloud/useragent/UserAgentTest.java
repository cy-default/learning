package com.rm13.cloud.useragent;

import cn.hutool.http.useragent.*;

public class UserAgentTest {

    public static void main(String[] args) {
        String uaStr = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36";

        UserAgent ua = UserAgentUtil.parse(uaStr);

        Browser browser = ua.getBrowser();
        String version = ua.getVersion();
        Engine engine = ua.getEngine();
        String engineVersion = ua.getEngineVersion();
        OS os = ua.getOs();
        Platform platform = ua.getPlatform();

        System.out.println("browser: "+browser);
        System.out.println("version: "+version);
        System.out.println("engine: "+engine);
        System.out.println("engineVersion: "+engineVersion);
        System.out.println("os: "+os);
        System.out.println("platform: "+platform);

    }

}
