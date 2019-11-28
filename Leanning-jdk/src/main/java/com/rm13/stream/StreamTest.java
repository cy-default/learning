package com.rm13.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-12
 */
public class StreamTest {

    private static List<Person> list  = null;


    public static void main(String[] args) {
        flatMap();
        reduce();
        // collectors
        toList();
        toSet();
        toMap();
        toTreeSet();
        toGroup();
        toJoining();
        emptyListFilter();
    }

    public static void toMap(){
        // collectors.toMap 仅支持 key, value 一一对应。
        System.out.println("toMap=="+list.stream().collect(Collectors.toMap(Person::getName, Function.identity())));
        System.out.println("=====");
        final Map<Integer, Person> collect = list.stream().collect(Collectors.toMap(Person::getAge, Function.identity(), (a, b) -> a));
        System.out.println("toMap==="+collect);
    }

    public static void toSet(){
        System.out.println("toSet=="+list.stream().map(Person::getSex).collect(Collectors.toSet()));
    }

    public static void toList(){
        System.out.println("toList=="+list.stream().map(Person::getName).collect(Collectors.toList()));
    }

    /**
     * 指定类型
     */
    public static void toTreeSet(){
        TreeSet<Person> collect = list.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println("toTreeSet=="+collect);
    }

    /**
     * 分组
     */
    public static void toGroup(){
        Map<String, List<Person>> collect = list.stream().collect(Collectors.groupingBy(person -> person.getSex()));
        System.out.println("toGroup=="+collect);
    }

    public static void toJoining(){
        String collect = list.stream().map(Person::getName).collect(Collectors.joining(",", "{", "}"));
        System.out.println("toJoining=="+collect);
    }

    public static void flatMap(){
        // flatMap
        List<String> collect0 = list.stream().flatMap(person -> Arrays.stream(person.getName().split(" "))).collect(Collectors.toList());
        System.out.println("flatMap=="+collect0);
    }

    public static void reduce(){
        // 累加， 初始值是 10
        Integer reduce1 = Stream.of(1,2,3,4).reduce(10, (count, item)->count+item);
        System.out.println(reduce1);

        String reduce2 = Stream.of("1", "2", "3", "4").reduce("0", (x, y) -> (x + "," + y));
        System.out.println(reduce2);
    }

    public static void emptyListFilter(){
        final ArrayList<String> arrayList = new ArrayList();
        final Optional<String> result = arrayList.stream().filter(t -> t.equals("cc")).findAny();
        if(result.isPresent()){
        System.out.println(result.get());
        }else{
            System.out.println("null");
        }


    }


    static {
        Person wu = new Person("wu qi", 18,"男");
        Person zhang = new Person("zhang san", 19,"男");
        Person wang = new Person("wang si", 20,"女");
        Person zhao = new Person("zhao wu", 20,"男");
        Person chen = new Person("chen liu", 21,"男");
        list = Arrays.asList(wu, zhang, wang, zhao, chen);
    }
}
