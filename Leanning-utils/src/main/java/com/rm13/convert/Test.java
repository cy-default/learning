package com.rm13.convert;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-28
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setAddress("上海");
        user.setName("lovemyrm13");
        UserDTO target = (UserDTO)Convert.convert(user, UserDTO.class);
        System.out.println(target);

    }
}
