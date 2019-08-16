package com.rm13.util;

import com.rm13.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-13
 */
public class Java8Stream {

    List<UserEntity> result = UserEntity.init();

    /**
     * 排序
     */
    @Test
    public void test1(){
        List<UserEntity> tmp =  result.stream().sorted(Comparator.comparing(UserEntity::getAge)).collect(Collectors.toList());
        System.out.println(tmp);
    }

    /**
     * 去重
     */
    @Test
    public void test2(){
        List<UserEntity> tmp = result.stream().distinct().collect(Collectors.toList());
        System.out.println(tmp);
    }

    /**
     * 分组
     * List -》 Map
     */
    @Test
    public void test3(){
        Map<String, List<UserEntity>> tmp = result.stream().distinct().collect(groupingBy(UserEntity::getCity));
        System.out.println(tmp);
    }

    /**
     * 转换
     * List -> Map
     */
    @Test
    public void test4(){
        Map<String, UserEntity> tmp = result.stream().distinct().collect(Collectors.toMap(UserEntity::getName,Function.identity()));
        System.out.println(tmp);
    }

    /**
     * 拼接字符串
     */
    @Test
    public void test5(){
        String tmp = result.stream().map(UserEntity::getName).collect(Collectors.joining(","));
        System.out.println(tmp);
    }

    /**
     * 将流中的每一个元素 T 映射为一个流，再把每一个流连接成为一个流
     *
     * 上面例子中，我们的目的是把 List 中每个字符串元素以" "分割开，变成一个新的 List<String>。
     * 首先 map 方法分割每个字符串元素，但此时流的类型为 Stream<String[ ]>，因为 split 方法返回的是 String[ ] 类型；
     * 所以我们需要使用 flatMap 方法，先使用Arrays::stream将每个 String[ ] 元素变成一个 Stream<String> 流，
     * 然后 flatMap 会将每一个流连接成为一个流，最终返回我们需要的  Stream<String>
     *
     */
    @Test
    public void flatMap(){
        List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");

        list = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 流中是否有一个元素匹配给定的 T -> boolean 条件
     */
    @Test
    public void match(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));
        // 是否存在一个 person 对象的 age 等于 20：
        boolean b = list.stream().anyMatch(person -> person.getAge() == 20);
        System.out.println("anyMatch="+b);

        b = list.stream().allMatch(person -> person.getAge() == 20);
        System.out.println("allMatch="+b);

        b = list.stream().noneMatch(person -> person.getAge() == 20);
        System.out.println("noneMatch="+b);
    }

    /**
     * findAny()：找到其中一个元素 （使用 stream() 时找到的是第一个元素；使用 parallelStream() 并行时找到的是其中一个元素）
     * findFirst()：找到第一个元素
     * 值得注意的是，这两个方法返回的是一个 Optional<T> 对象，
     */
    @Test
    public void find(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));
        System.out.println("findAny="+list.stream().findAny().get().toString());
        System.out.println("findFirst="+list.stream().findFirst().get().toString());
    }

    /**
     * 用于组合流中的元素，如求和，求积，求最大值等
     * 方法过后流变成了 Stream<Integer> 类型，而每个 Integer 都要拆箱成一个原始类型再进行 sum 方法求和，这样大大影响了效率。
     * 针对这个问题 Java 8 有良心地引入了数值流 IntStream, DoubleStream, LongStream，这种流中的元素都是原始数据类型，分别是 int，double，long
     */
    @Test
    public void reduce(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));

        // sum, 低效率
        Integer sum = list.stream().map(Person::getAge).reduce(0,Integer::sum);
        System.out.println("reduce="+sum);

        // sum, 低效率
        sum = list.stream().map(Person::getAge).reduce(0,(a, b)->a+b);
        System.out.println("reduce="+sum);

        // *, 低效率
        sum = list.stream().map(Person::getAge).reduce(1,(a, b)->a * b);
        System.out.println("reduce="+sum);

        // *, 高效率,避免装箱拆箱
        sum = list.stream().mapToInt(Person::getAge).reduce(1,(a, b)->a * b);
        System.out.println("reduce="+sum);

    }

    /**
     * 返回流中元素个数，结果为 long 类型
     */
    @Test
    public void count(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));
        System.out.println(list.stream().filter(p->"tom".equals(p.name)).count());
    }



    @Test
    public void joining(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));
        String s = list.stream().map(Person::getName).collect(Collectors.joining(" and ", "Today ", " play games."));
        System.out.println(s);
    }


    @Test
    public void groupby(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));
        Map<String, List<Person>> s = list.stream().collect(groupingBy(Person::getName));
        System.out.println(s);
    }

    @Data
    @AllArgsConstructor
    class Person{
        private String name;
        private Integer age;
    }

}
