package com.rm13.question;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-15
 *
 * 没有重写equals方法,所以位false
 */
public class Question20190813 {
    private String first, last;

    public Question20190813(String first, String last) {
        if (first == null || last == null)
            throw new NullPointerException();
        this.first = first;
        this.last = last;
    }

    public boolean equals(Question20190813 o) {
        return first.equals(o.first) && last.equals(o.last);
    }

    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set s = new HashSet();
        s.add(new Question20190813("Mickey", "Mouse"));
        System.out.println(s.contains(new Question20190813("Mickey", "Mouse")));
    }
}