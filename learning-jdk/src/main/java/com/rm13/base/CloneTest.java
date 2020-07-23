package com.rm13.base;

import com.rm13.optional.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/10
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<User> result1 = new ArrayList<>();
        result1.add(new User("11","11"));
        result1.add(new User("22","22"));

        ArrayList<User> clone = (ArrayList)result1.clone();
        clone.add(new User("33","33"));
        clone.get(0).setName("11111");

        System.out.println(result1);
        System.out.println(clone);

        LinkedList<Integer> before = new LinkedList<>();
        before.add(1);

        LinkedList<Integer> clone1 = (LinkedList<Integer>) before.clone();
        clone1.add(2);
        System.out.println(before);
        System.out.println(clone1);


        System.out.println("======");
        CloneData cloneData1 = new CloneData();
        cloneData1.setName("love");
        CloneData cloneData2 = (CloneData)cloneData1.clone();
        System.out.println(cloneData1.getName()==cloneData2.getName());
        System.out.println(cloneData1.getName().toString());
    }
}

@Data
class CloneData implements Cloneable{
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
