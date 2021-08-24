package com.learn.sortalgorithm.sort;

import java.util.Arrays;

/**
 * https://www.cnblogs.com/0zcl/p/6737944.html
 * <p>
 * 堆排序（最好时间复杂度：n log₂ n、最坏时间复杂度：n log₂ n、平均时间复杂度：n log₂ n、空间复杂度：1、稳定性：不稳）（重要）
 *
 * @author 姚壬亮
 */
public class HeapSort {

    private static final int[] ARRAY = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

    public static void main(String[] args) {

        int arrayLength = ARRAY.length;
        // 循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            // 建堆
            buildMaxHeap(ARRAY, arrayLength - 1 - i);
            // 交换堆顶和最后一个元素
            swap(ARRAY, 0, arrayLength - 1 - i);
            System.out.println(Arrays.toString(ARRAY));
        }

    }


    private static void swap(int[] data, int i, int j) {

        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;

    }

    // 对data数组从0到lastIndex建大顶堆
    private static void buildMaxHeap(int[] data, int lastIndex) {

        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    // 交换他们
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }

    }

}