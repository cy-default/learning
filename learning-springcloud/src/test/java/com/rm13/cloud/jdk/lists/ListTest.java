package com.rm13.cloud.jdk.lists;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class ListTest {

    public static void main(String[] args) {
        ArrayList<Integer> results = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
        results.forEach(t->{
            if(4==t){
                return;
            }
            System.out.println(t);
        });
    }
}
