package com.rm13.cloud.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-04
 */
@Data
@ConfigurationProperties(prefix = "person")
public class PersonProperties {

    private String name;
    private String password;
    private List<String> addr1;
    private List<String> addr2;
    private List<String> addr3;

    private Map<String, String> user1;
    private Map<String, String> user2;

    private List<Map<String, String>> detail1;
    private List<Map<String, String>> detail2;


}
