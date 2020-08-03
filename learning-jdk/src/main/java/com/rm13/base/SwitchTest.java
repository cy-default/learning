·package com.rm13.base;

/**
 * 通过反汇编查看字节码指令
 * <p>
 * switch 变量类型为 String类型的时候
 * 默认使用string.hashCode作为case值计算
 * 计算后再采用equals做比较
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/30
 */
public class SwitchTest {

    public static void main(String[] args) {
        String param = null;
        switch (param) {
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
