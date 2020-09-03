package com.rm13.algorithm.ratelimiter.demo;

/**
 * 采用滑动窗口算法实现（更优）
 * <p>
 * 给定一组大小为n的整数数组，计算长度为k的子数组（必须连续）和的最大值。例如：数组[-1，4，7，-3，8，5，-2，6]，k=2，那么最大值理应为：8+5 = 13
 * </p>
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/1
 */
public class CalNormal {

    public static void main(String[] args) {
        calNormal(new int[]{-1, 4, 7, -3, 8, 5, -2, 6}, 2);
        System.out.println("-------------");
        calBySlidingWindow(new int[]{-1, 4, 7, -3, 8, 5, -2, 6}, 2);
    }

    /**
     * 遍历所有子数组，求和并比较
     * 嵌套循环 时间复杂度：O(n*k)
     */
    public static void calNormal(int[] array, int k) {
        if (array.length == 0 || k <= 0 || k > array.length) {// 非法参数不处理
            return;
        }

        int index = 0;// 记录最大子数组第1个元素的索引，目前是0
        int maxSum = 0;// 记录最大子数组和，目前是从左开始第1个子数组
        for (int i = 0; i < k; i++) {
            maxSum += array[i];
        }

        // 当前maxSum是第一个数组的值，下面将【所有的子数组】相加比较
        // 遍历所有子数组，求和并比较（因为第一个数组已经计算了，所以此处角标从1开始即可）
        for (int i = 1; i <= array.length - k; i++) {
            int curSum = 0;
            for (int j = 0; j < k; j++) {// 计算当前子数组和
                curSum += array[i + j];
            }

            // 如果大于最大和，则记录maxSum为当前值，且记录index为i
            if (curSum > maxSum) {
                maxSum = curSum;
                index = i;
            }
        }

        /**打印结果*/
        System.out.print(maxSum + " // ");// 打印最大和
        System.out.print(array[index]);// 先打印第1个值
        for (int i = 1; i < k; i++) {
            int value = array[i + index];
            System.out.print(value >= 0 ? ("+" + value) : value);// 非负数前面打印+号
        }
        System.out.println();
    }

    /**
     * 窗口向右滑动，通过减失效值加最新值求和并比较
     * 单层循环 时间复杂度：O(n)
     */
    public static void calBySlidingWindow(int[] array, int k) {
        if (array.length == 0 || k <= 0 || k > array.length) {// 非法参数不处理
            return;
        }

        // 同上
        int index = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += array[i];
        }

        int curWindowSum = maxSum;
        // 从下个元素开始，即窗口向右滑动
        for (int i = 1; i <= array.length - k; i++) {
            // 减去失效值，加上最新值（窗口内元素固定嘛~这就是限流的思想）
            curWindowSum = curWindowSum - array[i - 1] + array[k + i - 1];
            if (curWindowSum > maxSum) {// 如果大于最大和，则记录
                maxSum = curWindowSum;
                index = i;
            }
        }

        /**打印结果*/
        System.out.print(maxSum + " // ");// 打印最大和
        System.out.print(array[index]);// 先打印第1个值
        for (int i = 1; i < k; i++) {
            int value = array[i + index];
            System.out.print(value >= 0 ? ("+" + value) : value);// 非负数前面打印+号
        }
        System.out.println();
    }
}
