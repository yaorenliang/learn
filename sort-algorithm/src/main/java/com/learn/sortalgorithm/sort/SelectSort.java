package com.learn.sortalgorithm.sort;

import com.free.basemode.util.ArrayUtil;
import com.free.basemode.util.SystemUtil;

/**
 * 选择排序（循环 10000000 次平均耗时 3100 毫秒）
 *
 * <p>
 * 简介：
 * 每次循环从本次循环中找出一个最小（大）值与本次循环的起始位置进行交换，每次循环次数 -1。
 * <p>
 * 执行流程：
 * 1.第一次循环，从下标 0 开始，记录本次循环中最小的下标，与 0 的值进行交换。
 * 2.因为上次循环中，下标 0 的值已经是整个数组中最小的值，所以接着从下标 1 开始，记录本次循环中最小的下标，与 1 的值进行交换。
 * 3.以此类推，不断重复，直到最后两个数据完成交换
 * <p>
 * 适用场景：
 * 选择排序的主要优点与数据移动有关。如果某个元素位于正确的最终位置上，则它不会被移动。
 * 选择排序每次交换一对元素，它们当中至少有一个将被移到其最终位置上，因此对n个元素的表进行排序总共进行至多n-1次交换。
 * 在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
 * <p>
 * 优化改进：
 * 1.二元选择排序
 * 简单选择排序，每趟循环只能确定一个元素排序后的定位。根据之前冒泡排序的经验，我们可以考虑改进为每趟循环确定两个元素（当前趟最大和最小记录）的位置，
 * 从而减少排序所需的循环次数。改进后对n个数据进行排序，最多只需进行[n/2]趟循环即可。
 * 2.堆排序
 * 堆排序是一种树形选择排序，是对直接选择排序的有效改进。具体的分析我们留到后面讲堆排序时再详细说明。
 *
 * @author 姚壬亮
 */
public class SelectSort {

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
        for (int i = 0; i < ARRAY.length - 1; i++) {
            int minSub = i;
            for (int j = i + 1; j < ARRAY.length; j++) {
                if (ARRAY[minSub] > ARRAY[j]) {
                    minSub = j;
                }
            }
//            System.err.println("第" + (i + 1) + "次选择最小值的下标为：" + minSub + "，值为：" + ARRAY[minSub]);
            ArrayUtil.swap(ARRAY, i, minSub);
//            System.err.println("第" + (i + 1) + "次排序结果：" + Arrays.toString(ARRAY));
//            System.err.println();
        }

    }

}
