package com.rm13.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/1/14
 */
public class ObjectCloneTest {


    public static void main(String[] args) throws CloneNotSupportedException {
        Cc cc = new Cc();
        cc.setName("lovemyrm13");
        cc.setAddr(new String[]{"13", "14"});
        cc.setAdds(Arrays.asList(cc.getAddr()));
        System.out.println(cc);
        System.out.println(cc.getAddr());
        System.out.println(cc.getAdds().hashCode());
        System.out.println(cc.getName());
        final Cc dd = (Cc) cc.clone();
        System.out.println(dd);
        System.out.println(dd.getName());
        System.out.println(cc.getAdds().hashCode());
        System.out.println(cc.getAdds()==dd.getAdds());


    }


    @Getter
    @Setter
    public static class Cc implements Cloneable{
        private String name;
        private String[] addr;
        private List<String> adds;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
