package com.learn.sortalgorithm.sort;

/**
 * https://www.cnblogs.com/lifexy/p/7597276.html
 *
 * 快速排序（最好时间复杂度：n log₂ n、最坏时间复杂度：n²、平均时间复杂度：n log₂ n、空间复杂度：log₂ n、稳定性：不稳）（重要）
 *
 * @author 姚壬亮
 */
public class QuickSort {

    private static final int[] ARRAY = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

    public static void main(String[] args) {

        int arrayLength = ARRAY.length;
        // 查看数组是否为空
        if (arrayLength > 0) {
            quickSort(ARRAY, 0, arrayLength - 1);
        }

    }

    private static void quickSort(int[] list, int low, int high) {

        if (low < high) {
            // 将list数组进行一分为二
            int middle = getMiddle(list, low, high);
            // 对低字表进行递归排序
            quickSort(list, low, middle - 1);
            // 对高字表进行递归排序
            quickSort(list, middle + 1, high);
        }

    }

    private static int getMiddle(int[] list, int low, int high) {

        // 数组的第一个作为中轴
        int tmp = list[low];
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            // 比中轴小的记录移到低端
            list[low] = list[high];
            while (low < high && list[low] <= tmp) {
                low++;
            }
            // 比中轴大的记录移到高端
            list[high] = list[low];
        }
        // 中轴记录到尾
        list[low] = tmp;
        // 返回中轴的位置
        return low;

    }

}
