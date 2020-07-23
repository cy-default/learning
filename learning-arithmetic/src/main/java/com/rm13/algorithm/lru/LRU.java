package com.rm13.algorithm.lru;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-31
 */
@Data
public class LRU<T> {

    private static final int DEFAULT_CAPACITY = 5;

    private Node head;

    private int capacity;

    private int size;

    public LRU() {
        head = new Node();
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public void add(T data){
        // 1: 拿结点的前一个结点

        // 2: 前一个结点存在，
        //  2.1: 删除存在的结点
        //  2.2: 添加新结点到头结点
        Node pre = preNode(data);
        if(pre!=null){
            removeExistedNode(pre);
            addHeadNode(data);
        }else{
            if(size>=capacity){
                removeEndNode();
            }
            addHeadNode(data);
        }
        print();
        // 3: 结点不存在
        //  3.1: 结点size小于capacity，添加结点到头结点
        //  3.2: 结点size大于等于capacity
        //    3.2.1:删除尾结点
        //    3.2.2:添加头结点
    }


    public void print(){
        Node current = head.getNext();
        while(current!=null){
            System.out.print(current.getElement()+" ");
            current = current.getNext();

        }
        System.out.println();
    }

    public void removeEndNode(){
        Node pre = head;

        if(head.getNext()==null){
            return;
        }

        while(pre.getNext().getNext()!=null){
            pre = pre.getNext();
        }

        pre.setNext(null);
        size--;

    }

    /**
     * 添加头结点
     * @param data
     */
    public void addHeadNode(T data){
        Node current = new Node(data, null);
        current.setNext(head.getNext());
        head.setNext(current);
        size++;
    }

    /**
     * 删除已存在的结点
     * @param pre
     */
    public void removeExistedNode(Node pre){
        pre.setNext(pre.next.next);
        size--;
    }

    /**
     * 拿结点的前一个结点
     * @param data
     * @return
     */
    public Node preNode(T data){
        Node current = head;
        while(current.next!=null){
            if(current.next.getElement().equals(data)){
                return current;
            }
            current = current.next;
        }
        return null;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Node<T>{
        private T element;
        private Node next;
    }


    public static void main(String[] args) {
        LRU lru = new LRU();
        Scanner scanner = new Scanner(System.in);

        while(true){
            int num = scanner.nextInt();
            lru.add(num);
        }


    }
}


