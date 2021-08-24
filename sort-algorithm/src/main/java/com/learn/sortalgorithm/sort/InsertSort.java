package com.learn.sortalgorithm.sort;

import com.free.basemode.util.ArrayUtil;
import com.free.basemode.util.SystemUtil;

/**
 * 插入排序（循环 10000000 次平均耗时 2950 毫秒）
 * <p>
 * 简介：
 * 插入排序的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * <p>
 * 执行流程：
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4.重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入到该位置后
 * 6.重复步骤 2 ~ 5
 * <p>
 * 适用场景：
 * 插入排序不适合对于数据量比较大的排序应用。但是，如果需要排序的数据量很小，例如量级小于千，那么插入排序还是一个不错的选择。
 * 尤其当数据基本有序时，采用插入排序可以明显减少数据交换和数据移动次数，进而提升排序效率。
 * 在STL的sort算法和stdlib的qsort算法中，都将插入排序作为快速排序的补充，用于少量元素的排序。
 * <p>
 * 优化改进：
 * 先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，然后依次缩减增量再进行排序，
 * 待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序。
 *
 * @author 姚壬亮
 */
public class InsertSort {

    private static final Integer[] ARRAY = {78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0, 78, 65, 38, 97, 76, 13, 27, 49, 0};

    public static void main(String[] args) {

        long startTime = SystemUtil.getNowMillisecond();
        for (int i = 0; i < 10000000; i++) {
            sort();
        }
        long endTime = SystemUtil.getNowMillisecond();
        System.err.println("耗时：" + (endTime - startTime));

    }

    private static void sort() {

//        System.err.println("排序前数组：" + Arrays.toString(ARRAY));
//        System.err.println();
        for (int i = 1; i < ARRAY.length; i++) {
            int minSub = i;
            for (int j = i - 1; j > -1; j--) {
                if (ARRAY[minSub] < ARRAY[j]) {
//                    System.err.println(ARRAY[j] + "与" + ARRAY[swapNum] + "交换");
                    ArrayUtil.swap(ARRAY, minSub, j);
                    minSub--;
                }
            }
//            System.err.println("第" + i + "次排序结果：" + Arrays.toString(ARRAY));
//            System.err.println();
        }

    }

}
