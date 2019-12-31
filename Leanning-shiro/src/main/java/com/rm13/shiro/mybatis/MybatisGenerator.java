package com.rm13.shiro.mybatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/23
 */
public class MybatisGenerator {

    public static void main(String[] args) {
        generator();
    }

    public static void generator(){
        try {
            System.out.println("+++++++++generate begin++++++++++");
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;

            String url = MybatisGenerator.class.getResource("/mybatis-generator/generatorConfig.xml").getFile();
            File configFile = new File(url);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("+++++++++generate writer end+++++++++++");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
