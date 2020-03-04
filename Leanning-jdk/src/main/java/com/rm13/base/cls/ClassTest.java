package com.rm13.base.cls;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-12-09
 */
public class ClassTest {

    public static void main(String[] args) {
        System.out.println("====1");
        for (Class<?> c : DemoCC.class.getInterfaces()) {
            System.out.println(c.getName());
        }
        System.out.println("====2");
        System.out.println(DemoCC.class.getDeclaredAnnotations().length);
        for (Annotation declaredAnnotation : DemoCC.class.getDeclaredAnnotations()) {
            System.out.println(declaredAnnotation.toString());
        }
        System.out.println("====3");
        System.out.println(DemoCC.class.getAnnotations().length);
        for (Annotation declaredAnnotation : DemoCC.class.getAnnotations()) {
            System.out.println(declaredAnnotation.toString());
        }

        System.out.println(DemoCC.class.toGenericString());
        System.out.println(DemoCC.class.toString());

        System.out.println(DemoCC.class.getModifiers());
        final Constructor<?>[] declaredConstructors = BB.class.getDeclaredConstructors();
        final Constructor<?> constructor = Arrays.asList(declaredConstructors).stream().findAny().orElse(null);
        if(constructor!=null){
            System.out.println(constructor.getName());
        }

    }
}

interface A{
    void a();
}
@MyAnnotaion("ccc")
interface B extends A{
    void b();
}

interface C extends B{
    void c();
}

class AA extends BB{

    public AA(String name) {
        super(name);
    }
}
@MyAnnotaion("cc")
 class BB extends CC{

    private String name;

    public BB(String name) {
        super(name);
        this.name = name;
    }
}

class CC{

    private String name;

    public CC(String name) {
        this.name = name;
    }
}