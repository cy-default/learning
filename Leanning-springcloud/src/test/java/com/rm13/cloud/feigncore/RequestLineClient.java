package com.rm13.cloud.feigncore;

import feign.*;

import java.util.Map;

/**
 * 模版表达式必须用{}包起来才算一个表达式(变量)，里面的值就是name（key），才会被@Param匹配然后替换掉~
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/19
 */
public interface RequestLineClient {

    /**
     * 1： 正常使用， 正常书写
     *
     * @param name
     * @return
     */
    @Headers({"Accept:*/*", "Accept-Language:    zh-cn"})
    @RequestLine("GET /feign/demo1?name={name}")
    String testRequestLine(@Param("name") String name);

    /**
     * 2： GET 后不止一个空格， 有多个空格
     */
    @RequestLine("GET       /feign/demo1?name={name}")
    String testRequestLine2(@Param("name") String name);

    /**
     * 3： 使用map一次性传递多个查询参数， 使用注解为@QueryMap
     *
     * @param param
     * @return
     */
    @RequestLine("GET /feign/demo1")
    String testRequestLine3(@QueryMap Map<String, Object> param);

    /**
     * 4： 方法参数上不使用任何注解 (报错)
     * {"code":405,"message":"请求方法不支持","data":null,"ok":true}
     *
     * @param name
     * @return
     */
    @RequestLine("GET /feign/demo1")
    String testRequestLine4(String name);

    /**
     * 5： 方法上标注有@Body注解， 然后把方法参数传递给他 (报错)
     * {"code":405,"message":"请求方法不支持","data":null,"ok":true}
     *
     * @param name
     * @return
     */
    @RequestLine("GET /feign/demo1")
    @Body("{name}")
    String testRequestLine5(@Param("name") String name);

    /**
     * 6： 方法2个参数， 均不使用注解标注
     * （启动直接报错 Method has too many Body parameters:）
     *
     * @param name
     * @param age
     * @return
     */
    //@RequestLine("GET /feign/demo1")
    //String testRequestLine6(String name, Integer age);

    /**
     * 7： 启动直接报错（Body parameters cannot be used with form parameters.）
     *
     * @param name
     * @param age
     * @return
     */
    //@RequestLine("GET /feign/demo1")
    //@Body("{name}")
    //String testRequestLine7(@Param("name") String name, Integer age);

    /**
     * 8： 如果你即想要body参数， 又想要查询参数， 可以这么写（报错）
     * {"code":405,"message":"请求方法不支持","data":null,"ok":true}
     *
     * @param name
     * @param age
     * @return
     */
    @RequestLine("GET /feign/demo1?name={name}")
    @Body("{age}")
    String testRequestLine8(@Param("name") String name, @Param("age") Integer age);
}
