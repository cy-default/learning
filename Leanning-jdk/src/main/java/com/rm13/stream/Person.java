package com.rm13.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-11-12
 */
@Data
@AllArgsConstructor
public class Person implements Comparable {
    private String name;
    private Integer age;
    private String sex;

    @Override
    public int compareTo(Object com) {
        Person o = (Person) com;
        if(this.age>o.age){
            return 1;
        }else if (this.age.equals(o.age)){
            return 0;
        }else{
            return -1;
        }
    }

}
