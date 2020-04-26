package com.rm13.array;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-10
 */
public class ArrayTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //cloneTest01();
        cloneTest02();
    }

    public static void cloneTest01(){
        ArrayList list = new ArrayList<TT>(2);
        list.add(new TT("a1"));
        list.add(new TT("a2"));
        ArrayList<TT> list2 = (ArrayList)list.clone();
        System.out.println(list);
        System.out.println(list2);
        list2.get(0).setName("a3");
        System.out.println(list2);
        System.out.println(list);
    }


    public static void cloneTest02() throws CloneNotSupportedException {
         TT a1 = new TT("a1");
        final TT clone = (TT)a1.clone();
        System.out.println(clone);
        System.out.println(a1);
        clone.setName("a2");
        System.out.println(clone);
        System.out.println(a1);
    }

    public static void move(){
        int num = 1;
        System.out.println(num >> 1);
        System.out.println(num<<2);
    }


    static class TT implements Cloneable{
        private String name;
        public TT(String name) {
            this.name = name;
        }
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "TT{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}


