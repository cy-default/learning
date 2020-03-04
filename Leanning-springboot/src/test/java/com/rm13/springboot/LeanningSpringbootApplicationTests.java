package com.rm13.springboot;

import com.alibaba.fastjson.JSON;
import com.rm13.springboot.model.dto.DemoDTO;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@SpringBootTest
public class LeanningSpringbootApplicationTests {


    @Test
     public void classPathTest() throws IOException {
        System.out.println(this.getClass().getResource("/demo.json").getPath());
    }
}
