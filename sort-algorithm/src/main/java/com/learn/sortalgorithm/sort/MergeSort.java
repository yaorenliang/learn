package com.learn.sortalgorithm.sort;

import java.util.Arrays;

/**
 * https://blog.csdn.net/k_koris/article/details/80508543
 * <p>
 * 归并排序（最好时间复杂度：n log₂ n、最坏时间复杂度：n log₂ n、平均时间复杂度：n log₂ n、空间复杂度：n、稳定性：稳）（重要）
 *
 * @author 姚壬亮
 */
public class MergeSort {

    private static final int[] ARRAY = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

    public static void main(String[] args) {

        sort(ARRAY, 0, ARRAY.length - 1);
        System.out.println(Arrays.toString(ARRAY));

    }

    private static void sort(int[] data, int left, int right) {

        if (left < right) {
            // 找出中间索引
            int center = (left + right) / 2;
            // 对左边数组进行递归
            sort(data, left, center);
            // 对右边数组进行递归
            sort(data, center + 1, right);
            // 合并
            merge(data, left, center, right);
        }

    }

    private static void merge(int[] data, int left, int center, int right) {

        int[] tmpArr = new int[data.length];
        int mid = center + 1;
        // third记录中间数组的索引
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入中间数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }
        // 剩余部分依次放入中间数组
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将中间数组中的内容复制回原数组
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
        System.out.println(Arrays.toString(data));

    }

}
