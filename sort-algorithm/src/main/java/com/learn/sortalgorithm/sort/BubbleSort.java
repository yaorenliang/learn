package com.learn.sortalgorithm.sort;

import com.free.basemode.util.ArrayUtil;
import com.free.basemode.util.SystemUtil;

import java.util.Arrays;

/**
 * 冒泡排序（循环 10000000 次平均耗时 500 毫秒）
 * <p>
 * 简介：
 * 冒泡排序顾名思义就是整个过程像气泡一样往上升
 * <p>
 * 执行流程：
 * 1.循环对比相邻（n 和 n+1）两个值，当前面的值大于后边的值时（n 大于 n+1），进行交换
 * 2.记录每次循环的交换次数，如果交换次数为 0 就代表数组已排序完成
 * <p>
 * 适用场景：
 * 冒泡排序思路简单，代码也简单，特别适合小数据的排序。但是，由于算法复杂度较高，在数据量大的时候不适合使用。
 * 如果一定要在较多数据的时候使用，最好对算法加以改进。冒泡排序毕竟是一种效率低下的排序方法，在数据规模很小时，可以采用。
 * 数据规模比较大时，建议采用其它排序方法。
 * <p>
 * 优化改进：
 * 1.通过设置标志位来记录此次遍历有无数据交换，进而可以判断是否要继续循环，设置一个 Flag 标记，
 * 当在一趟序列中没有发生交换，则该序列已排序好，但优化后排序的时间复杂度没有发生量级的改变。
 * 2.记录某次遍历时最后发生数据交换的位置 endSwap ，这个位置之后的数据显然已经有序了。
 * 因此通过记录最后发生数据交换的位置就可以确定下次循环的范围了。由于 endSwap 位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到 endSwap 位置即可。
 *
 * @author 姚壬亮
 **/
public class BubbleSort {

    private static final Integer[] ARRAY = {78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0};

    public static void main(String[] args) {

        long startTime = SystemUtil.getNowMillisecond();
        for (int j = 0; j < 10000000; j++) {
            superSort();
        }
        long endTime = SystemUtil.getNowMillisecond();
        System.err.println("耗时：" + (endTime - startTime));

    }

    private static void sort() {

//         System.err.println("排序前数组：" + Arrays.toString(ARRAY));
//         System.err.println();
        for (int i = 0; i < ARRAY.length; i++) {
            for (int j = 0; j < ARRAY.length - 1; j++) {
                if (ARRAY[j + 1] < ARRAY[j]) {
                    ArrayUtil.swap(ARRAY, j, j + 1);
                }
            }
//            System.err.println("第" + (i + 1) + "次排序结果：" + Arrays.toString(ARRAY));
//            System.err.println();
        }

    }

    private static void superSort() {

        System.err.println("排序前数组：" + Arrays.toString(ARRAY));
        System.err.println();
        // 最后交换的位置
        int endSwap = ARRAY.length;
        for (int i = 0; i < ARRAY.length; i++) {
            // 是否进行了交换
            boolean swapNum = true;
            int num = 0;
            // 从上次结束的位置开始
            for (int j = 0; j < endSwap - 1; j++) {
                if (ARRAY[j + 1] < ARRAY[j]) {
                    ArrayUtil.swap(ARRAY, j, j + 1);
                    // 记录最后一次交换的位置
                    num = j + 1;
                    // 进行了交换
                    swapNum = false;
                }
            }
            // 记录最后交换的位置
            endSwap = num;
            // 如果本次没有进行交换就表示已经是最终结果，直接跳出循环
            if (swapNum) {
                break;
            }
            System.err.println("第" + (i + 1) + "次排序结果：" + Arrays.toString(ARRAY));
            System.err.println();
        }

    }

}
