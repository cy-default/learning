package com.rm13.systemenv;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-12
 */
@Slf4j
public class RunEnv {

    public static void main(String[] args) throws IOException {
        // 查看进程详情： ps aux|grep xxx
        log.info("RunEnv...");
        System.in.read();
    }
}

/**

 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/bin/java
 -javaagent:/Users/chenyuan/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/191.7479.19/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=50748:
 /Users/chenyuan/Library/Application Support/JetBrains/Toolbox/apps/IDEA-U/ch-0/191.7479.19/IntelliJ IDEA.app/Contents/bin
 -Dfile.encoding=UTF-8
 -classpath
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/charsets.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/deploy.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/dnsns.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/jaccess.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/localedata.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/nashorn.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/sunec.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/ext/zipfs.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/javaws.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/jce.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/jfr.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/jfxswt.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/jsse.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/management-agent.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/com.rm13.mybatis.plugin.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/resources.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/jre/lib/rt.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/ant-javafx.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/dt.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/javafx-mx.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/jconsole.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/packager.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/sa-jdi.jar:
 /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home/lib/tools.jar:
 /Users/chenyuan/Documents/project/collect/Leanning/Leanning-jdk/target/classes:
 /Users/chenyuan/.m2/repository/org/apache/commons/commons-lang3/3.9/commons-lang3-3.9.jar:
 /Users/chenyuan/.m2/repository/cn/hutool/hutool-all/4.6.1/hutool-all-4.6.1.jar:
 /Users/chenyuan/.m2/repository/org/springframework/boot/spring-boot-starter-web/2.1.8.RELEASE/spring-boot-starter-web-2.1.8.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/springframework/boot/spring-boot-starter/2.1.8.RELEASE/spring-boot-starter-2.1.8.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/springframework/boot/spring-boot/2.1.8.RELEASE/spring-boot-2.1.8.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/2.1.8.RELEASE/spring-boot-autoconfigure-2.1.8.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/springframework/boot/spring-boot-starter-logging/2.1.8.RELEASE/spring-boot-starter-logging-2.1.8.RELEASE.jar:
 /Users/chenyuan/.m2/repository/ch/qos/logback/logback-classic/1.2.3/logback-classic-1.2.3.jar:
 /Users/chenyuan/.m2/repository/ch/qos/logback/logback-core/1.2.3/logback-core-1.2.3.jar:
 /Users/chenyuan/.m2/repository/org/slf4j/slf4j-api/1.7.28/slf4j-api-1.7.28.jar:
 /Users/chenyuan/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.11.2/log4j-to-slf4j-2.11.2.jar:
 /Users/chenyuan/.m2/repository/org/apache/logging/log4j/log4j-api/2.11.2/log4j-api-2.11.2.jar:
 /Users/chenyuan/.m2/repository/org/slf4j/jul-to-slf4j/1.7.28/jul-to-slf4j-1.7.28.jar:
 /Users/chenyuan/.m2/repository/javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2.jar:
 /Users/chenyuan/.m2/repository/org/springframework/spring-core/5.1.9.RELEASE/spring-core-5.1.9.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/springframework/spring-jcl/5.1.9.RELEASE/spring-jcl-5.1.9.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/yaml/snakeyaml/1.23/snakeyaml-1.23.jar:
 /Users/chenyuan/.m2/repository/org/springframework/boot/spring-boot-starter-json/2.1.8.RELEASE/spring-boot-starter-json-2.1.8.RELEASE.jar:
 /Users/chenyuan/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.9.9.3/jackson-databind-2.9.9.3.jar:
 /Users/chenyuan/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.9.0/jackson-annotations-2.9.0.jar:
 /Users/chenyuan/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.9.9/jackson-core-2.9.9.jar:
 /Users/chenyuan/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.9.9/jackson-datatype-jdk8-2.9.9.jar:
 /Users/chenyuan/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.9.9/jackson-datatype-jsr310-2.9.9.jar:
 /Users/chenyuan/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.9.9/jackson-module-parameter-names-2.9.9.jar:
 /Users/chenyuan/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/2.1.8.RELEASE/spring-boot-starter-tomcat-2.1.8.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/9.0.24/tomcat-embed-core-9.0.24.jar:
 /Users/chenyuan/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/9.0.24/tomcat-embed-el-9.0.24.jar:
 /Users/chenyuan/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/9.0.24/tomcat-embed-websocket-9.0.24.jar:
 /Users/chenyuan/.m2/repository/org/hibernate/validator/hibernate-validator/6.0.17.Final/hibernate-validator-6.0.17.Final.jar:
 /Users/chenyuan/.m2/repository/javax/validation/validation-api/2.0.1.Final/validation-api-2.0.1.Final.jar:
 /Users/chenyuan/.m2/repository/org/jboss/logging/jboss-logging/3.3.3.Final/jboss-logging-3.3.3.Final.jar:
 /Users/chenyuan/.m2/repository/com/fasterxml/classmate/1.4.0/classmate-1.4.0.jar:
 /Users/chenyuan/.m2/repository/org/springframework/spring-web/5.1.9.RELEASE/spring-web-5.1.9.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/springframework/spring-beans/5.1.9.RELEASE/spring-beans-5.1.9.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/springframework/spring-webmvc/5.1.9.RELEASE/spring-webmvc-5.1.9.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/springframework/spring-aop/5.1.9.RELEASE/spring-aop-5.1.9.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/springframework/spring-context/5.1.9.RELEASE/spring-context-5.1.9.RELEASE.jar:
 /Users/chenyuan/.m2/repository/org/springframework/spring-expression/5.1.9.RELEASE/spring-expression-5.1.9.RELEASE.jar
 com.rm13.systemenv.RunEnv
 */