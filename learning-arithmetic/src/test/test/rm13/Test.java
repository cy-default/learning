package test.rm13;

import java.util.Iterator;
import java.util.Map;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-29
 */
public class Test {

    public static void main(String[] args) {
        env();
    }

    public static void properties(){
        System.out.println(1<<3);
        Map result = (Map)System.getProperties();
        Iterator it = result.keySet().iterator();
        while(it.hasNext()){
            Object key = it.next();
            Object rt = result.get(key);
            System.out.println(key+"=="+rt);

        }
    }

    public static void env(){
        Map result = System.getenv();
        System.out.println(result);
    }

    public static void finaltt(){
        final String result;
        result = "11";
    }
}
