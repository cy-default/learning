package com.rm13.stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-12
 */
public class StreamTest {

    private static List<Person> list  = null;

    public static void toMap(){
        // collectors.toMap 仅支持 key, value 一一对应。
        System.out.println("toMap=="+list.stream().collect(Collectors.toMap(Person::getName, Function.identity())));
        System.out.println("=====");
        // 取第一个参数
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
        Map<String, List<Person>> collect = list.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println("toGroup=="+collect);

        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        toGroup();
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
        Integer reduce1 = Stream.of(1,2,3,4).reduce(10, Integer::sum);
        System.out.println(reduce1);
        // 字符串拼接
        String reduce2 = Stream.of("1", "2", "3", "4").reduce("0", (x, y) -> (x + "," + y));
        System.out.println(reduce2);
        // bigDecimal,无初始值
        BigDecimal bigDecimal = Stream.of(new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("1")).reduce(BigDecimal::add).get();
        System.out.println(bigDecimal);
        // 过滤空值后 做计算操作
        final BigDecimal o = Stream.of((BigDecimal)null).filter(e->e!=null).reduce(BigDecimal::add).orElse(BigDecimal.ONE);
        System.out.println(o);
    }

    public static void emptyListFilter(){
        ArrayList<String> arrayList = new ArrayList();
        String result = arrayList.stream().filter(t -> t.equals("cc")).findFirst().orElse("null");
        System.out.println(result);
    }


    public static void baseTypeStream(){
        // [0, 10)
        LongStream.range(0L, 10L).boxed().forEach(System.out::println);
        System.out.println("==========");
        // [0, 10]
        LongStream.rangeClosed(0L, 10L).boxed().forEach(System.out::println);
        System.out.println("==========");
        // Collector
        ConcurrentHashMap<String, Long> result = LongStream.rangeClosed(0L, 10L).boxed().collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(), (o1, o2) -> o1, ConcurrentHashMap::new));
        System.out.println(result.size());
        System.out.println("==========");
        // 无状态数据流顺序 0 ->peek 0 ->peek 0 -> sout -> sum
        LongStream.range(0L, 10L).peek(System.out::println).peek(System.out::println).sum();
        System.out.println("==========");
        // reduce
        System.out.println(LongStream.range(0L, 10L).boxed().reduce(Long::sum).orElse(-1L));
        System.out.println(Stream.of(new BigDecimal("0.1"), new BigDecimal("0.2"), new BigDecimal("0.3")).reduce(BigDecimal::add).orElse(new BigDecimal("-1")));
    }

    public static void parllonStream1(){
        // 多线程 ==> 使用ForkJoinPool.commonPool
        IntStream.range(0,10)
                .parallel()
                .forEach(v-> System.out.println(Thread.currentThread().getName().concat("====").concat(""+v)));
        // ForkJoinPool测试
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        System.out.println(forkJoinPool);
        String pp = System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism");
        System.out.println(pp);
    }

    public static void parllonStream2() throws InterruptedException {
        // 多线程 ==> 使用ForkJoinPool.commonPool 3个线程
        /*
        IntStream.range(0,10)
                .parallel()
                .forEach(v-> System.out.println(Thread.currentThread().getName().concat("====").concat(""+v)));
         */
        System.out.println("========================================");
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.execute(()->{
            IntStream.rangeClosed(1,10)
                    .parallel()
                    .forEach(v-> System.out.println(Thread.currentThread().getName().concat("====").concat(""+v)));
        });
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
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
