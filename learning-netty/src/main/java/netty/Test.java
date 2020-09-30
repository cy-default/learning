package netty;

import com.sun.media.sound.SoftTuning;
import io.netty.util.internal.SystemPropertyUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/25
 */
public class Test {

    public static void main(String[] args) {
        final List<Integer> integers = Arrays.asList(1);
        final HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);


        final Set<Integer> collect = integers.stream().filter(t -> !map.containsKey(t)).collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println("=========");

        final int max = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventLoop.maxPendingTasks", Integer.MAX_VALUE));
        System.out.println(max);

        System.out.println("==========");
        System.out.println("LV2".compareTo("LV10"));
    }
}
