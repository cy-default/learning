package com.rm13.base;

import com.rm13.optional.User;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/10
 */
public class CloneTest {

    public static void main(String[] args) {
        ArrayList<User> result1 = new ArrayList<>();
        result1.add(new User("11","11"));
        result1.add(new User("22","22"));

        ArrayList<User> clone = (ArrayList)result1.clone();
        clone.add(new User("33","33"));
        clone.get(0).setName("11111");

        System.out.println(result1);
        System.out.println(clone);

        LinkedList<Integer> before = new LinkedList<>();
        before.add(1);

        LinkedList<Integer> clone1 = (LinkedList<Integer>) before.clone();
        clone1.add(2);
        System.out.println(before);
        System.out.println(clone1);
    }
}
