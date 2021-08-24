package com.learn.sortalgorithm.sort;


import com.free.basemode.util.SystemUtil;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/tojian/p/10112303.html
 * https://blog.csdn.net/weixin_37818081/article/details/79202115
 * <p>
 * 希尔排序（最小增量排序）（最好时间复杂度：n、最坏时间复杂度：n²、平均时间复杂度：n1.3、空间复杂度：1、稳定性：不稳）
 *
 * @author 姚壬亮
 */
public class ShellSort {

    private static final Integer[] ARRAY = {78, 65, 38, 97, 76, 13, 27, 49, 0};

    public static void main(String[] args) {

        long startTime = SystemUtil.getNowMillisecond();
        for (int j = 0; j < 1; j++) {
            sort();
        }
        long endTime = SystemUtil.getNowMillisecond();
        System.err.println("耗时：" + (endTime - startTime));

    }

    private static void sort() {

        System.err.println("排序前数组：" + Arrays.toString(ARRAY));
        int i, j, k, arrayLength = ARRAY.length;
        // 几组循环几次
        for (i = arrayLength / 2; i > 0; i /= 2) {
            // 分组
            for (j = i; j < arrayLength; j++) {
                int temp = ARRAY[j];
                for (k = j - i; k > -1 && ARRAY[k] > temp; k -= i) {
                    ARRAY[k + i] = ARRAY[k];
                }
                ARRAY[k + i] = temp;
            }

        }
        System.err.println("排序后数组：" + Arrays.toString(ARRAY));

    }

}
