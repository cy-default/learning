package com.rm13.springboot.util;

import com.google.common.collect.Maps;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author lovemyrmb
 * @Description: 通用工具类
 * @date 2018-10-31 16:26
 */
public class RequestUtil {

    private static final String UNKOWN = "unkown";

    /**
     * 获取请求参数
     * @param request
     * @return
     */
    public static Map<String,String> getParameterMap(HttpServletRequest request){
        Map map = Maps.newHashMap();
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()){
             String parameterName=names.nextElement();
            map.put(parameterName, request.getParameter(parameterName));
        }
        return map;
    }

    /**
     * 获取请求IP
     * @param request
     * @return
     * @throws Exception
     */
    public static String getIp(HttpServletRequest request) throws Exception{
        if(request == null){
            throw  new Exception("request对象为空");
        }
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.trim() == "" || UNKOWN.equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.trim() == "" || UNKOWN.equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.trim() == "" || UNKOWN.equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        final String[] arr = ip.split(",");
        for (final String str : arr){
            if(!"unknown".equalsIgnoreCase(str)){
                ip = str;
                break;
            }
        }
        return ip;
    }

    /**
     * 获取请求方式: 普通请求, ajax请求
     * @param request
     * @return
     * @throws Exception
     */
    public static Integer getType(HttpServletRequest request) throws Exception{
        if(request == null){
            throw  new Exception("request对象为空");
        }
        String xRequestWith = request.getHeader("X-Requested-With");
        return xRequestWith == null ? 1:2;
    }
}
