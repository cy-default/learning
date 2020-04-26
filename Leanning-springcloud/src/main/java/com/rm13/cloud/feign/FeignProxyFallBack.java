package com.rm13.cloud.feign;

import com.rm13.cloud.bean.User;
import feign.Logger;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/12
 */
@Slf4j
@Component
public class FeignProxyFallBack implements FeignProxy {


    @Override
    public String after1(User user, String ab) {
        log.error("FeignProxyFallBack.after1");
        return "after1";
    }

    @Override
    public String after2(String a, String b, String ab) {
        log.error("FeignProxyFallBack.after2");
        return "after2";
    }

    @Override
    public String after3(Map<String, String> param, String ab) {
        log.error("FeignProxyFallBack.after3");
        return "after3";
    }

    @Override
    public String after4(Map<String, ?> user, String ab) {
        log.error("FeignProxyFallBack.after4");
        return "after4";
    }
}
