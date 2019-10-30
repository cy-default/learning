package test.rm13;

import lombok.Data;

import java.util.Scanner;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-09-10
 */
public class LRUU {

    private int CAPACITY = 5;

    private Node<Integer> head;

    private int size = 0;

    public LRUU() {
        head = new Node<Integer>();
    }

    /*
        1: 数据存在
          1.1:
        2: 数据不存在
          2.1: size满了
          2.2: size未满
         */
    public void add(Integer item){
        Node pre = findPreNode(item);
        if(pre!=null){
            // 删除已存在结点
            deleteNode(pre);
            // 添加头结点
            addHead(item);
        }else{
            if(size>=CAPACITY){
                deleteLastNode();
            }
            addHead(item);
        }
    }

    public void deleteLastNode(){
        Node node = head;
        if(node.getNext()==null){
            return;
        }

        while(node.getNext().getNext()!=null){
            node = node.getNext();
        }
        node.setNext(null);
        size--;

    }

    public void addHead(Integer item){
        Node node = new Node();
        node.setItem(item);
        node.setNext(head.getNext());
        head.setNext(node);
        size++;
    }

    public void deleteNode(Node pre){
        pre.setNext(pre.getNext().getNext());
        size--;
    }


    public Node findPreNode(Integer item){
        Node node = head;
        while(node.getNext()!=null){
            if(item.equals(node.getNext().getItem())){
                return node;
            }
            node = node.getNext();
        }
        return null;

    }

    public void print(){
        Node node = head;
        while(node.getNext()!=null){
            node = node.getNext();
            System.out.print(" "+node.getItem());

        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUU lru =new LRUU();
        Scanner scanner = new Scanner(System.in);
        while (true){
            int num = scanner.nextInt();
            lru.add(num);
            lru.print();
        }
    }


    @Data
    class Node<Integer>{
        private Integer item;
        private Node<Integer> next;
    }

}

