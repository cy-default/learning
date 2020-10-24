package com.rm13.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/10/14
 */
public class SortTest {

    static List<User> users = new ArrayList<>();

    static List<User> users2 = new ArrayList<>();

}


@AllArgsConstructor
@Data
class User {
    private String name;
    private String type;
}