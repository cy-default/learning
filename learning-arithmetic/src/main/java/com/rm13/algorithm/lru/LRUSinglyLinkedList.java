package com.rm13.algorithm.lru;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

/**
 * 单向链表实现LRU
 * 添加元素
 *  1：若链表中存在该元素，将存在的元素删除，并插入一个新的元素到头结点
 *  2：若链表中不存在该元素
 *      2.1：若链表容量已满，删除链表最后一个元素，插入一个新的元素到头结点
 *      2.2：若链表容量未满，插入一个新的元素到头结点
 *
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-29
 */
public class LRUSinglyLinkedList<T> {

    /**
     * 默认链表容量
     */
    private static final Integer DEFAULT_CAPACITY = 5;

    /**
     * 头结点
     */
    private Node head;

    /**
     * 链表长度
     */
    private Integer size;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUSinglyLinkedList() {
        head = new Node();
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;

    }

    public LRUSinglyLinkedList(Integer capacity) {
        this.capacity = capacity;
    }

    public void add(T data){
        Node current = new Node(data, null);
        // 获取查找元素的前一个结点
        Node pre = findPreNode(data);
        // 链表中存在，删除原有数据，再插入到链表头部
        if(pre != null){
            // 删除原有数据
            deleteExistedElement(pre);
            // 插入到链表头部
            insertElementAtHead(current);
        }else{
            // 链表中不存在， 若size大于容器大小，删除链表最后一个元素。
            if(size>=capacity){
                deleteElementAtEnd();
            }
            insertElementAtHead(current);
        }

    }


    /**
     * 查找值相等元素的前一个结点
     * @param data
     * @return
     */
    public Node findPreNode(T data){
        Node current = head;
        while(current.getNext()!=null){
            if(data.equals(current.getNext().getElement())){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * 删除已存在的结点
     * @param pre
     */
    public void deleteExistedElement(Node pre){
        Node current = pre.getNext();
        pre.setNext(current.getNext());
        size--;
    }

    /**
     * 在头结点插入元素
     * @param current
     */
    public void insertElementAtHead(Node current){
        current.setNext(head.getNext());
        head.setNext(current);
        size++;
    }

    /**
     * 删除尾结点
     */
    public void deleteElementAtEnd(){
        Node node = head;
        Node pre = head;
        while(node.getNext()!=null){
            pre = node;
            node = node.getNext();
        }
        pre.setNext(null);
        size--;
    }

    public void print(){
        Node node = head.getNext();
        while (node!=null){
            System.out.print(node.getElement() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUSinglyLinkedList lru = new LRUSinglyLinkedList();
        Scanner scanner = new Scanner(System.in);
        while (true){
            lru.add(scanner.nextInt());
            lru.print();
        }
    }

}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Node<T>{
    private T element;
    private Node next;
}