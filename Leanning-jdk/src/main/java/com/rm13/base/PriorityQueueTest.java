package com.rm13.base;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/4/20
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        });
        queue.add(4);
        queue.add(2);
        queue.add(3);
        queue.add(11);
        System.out.println(queue);
        System.out.println("------");
        final Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(queue.poll());
        }
    }
}

class App {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<String>();
        //入列
        q.offer("3");
        q.offer("4");
        q.offer("1");
        q.offer("2");
        q.offer("5");


        //出列
        System.out.println(q.poll());  //1
        System.out.println(q.poll());  //2
        System.out.println(q.poll());  //3
        System.out.println(q.poll());  //4
        System.out.println(q.poll());  //5
    }
}