package com.botany.mint.algorithm.sort;

/**
 * 冒泡排序是个双层循环
 *
 * <pre>
 *     1.相邻两个数字比较，较大的一个右移
 *     2.交换排序的一种
 *     3.时间复杂度：O(n²)
 * </pre>
 * @author wangzh
 * @version 1.0
 * @create 2018-12-05 19:30
 */
public class BubbleSort implements Sort{
    @Override
    public int[] sort(int[] unsorted) {
        for (int i = 0; i < unsorted.length; i ++) {
            for (int j = 0; j < unsorted.length - i -1; j++) {
                if (unsorted[j] > unsorted[j + 1]) {
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                }
            }
        }
        return unsorted;
    }
}
