package com.learn.sortalgorithm.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.cnblogs.com/ECJTUACM-873284962/p/6935506.html
 * <p>
 * 基数排序（最好时间复杂度：n * k、最坏时间复杂度：n * k、平均时间复杂度：n * k、空间复杂度：n + k、稳定性：稳）
 *
 * @author 姚壬亮
 */
public class RadixSort {

    private static final int[] ARRAY = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

    public static void main(String[] args) {

        // 首先确定排序的趟数;
        int max = ARRAY[0];
        for (int i = 1; i < ARRAY.length; i++) {
            if (ARRAY[i] > max) {
                max = ARRAY[i];
            }
        }
        int time = 0;
        // 判断位数;
        while (max > 0) {
            max /= 10;
            time++;
        }
        // 建立10个队列;
        List<ArrayList<Integer>> queue = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = Lists.newArrayList();
            queue.add(queue1);
        }
        // 进行time次分配和收集;
        for (int i = 0; i < time; i++) {
            // 分配数组元素;
            for (int value : ARRAY) {
                // 得到数字的第time+1位数;
                int x = value % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(value);
                queue.set(x, queue2);
            }
            // 元素计数器;
            int count = 0;
            // 收集队列元素;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> queue3 = queue.get(k);
                    ARRAY[count] = queue3.get(0);
                    queue3.remove(0);
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(ARRAY));

    }

}
