package com.botany.mint.algorithm.sort;

/**
 * 快速排序
 * <pre>
 *     1. 两边向中间与基准值比较，右边找小，左边找大，未相遇则交换，相遇则取小于基准值交换，递归两边
 *     2. 交换排序的一种
 *     3. 平均时间复杂度: O(nlogn)
 * </pre>
 * @author wangzh
 * @version 1.0
 * @create 2018-12-06 17:39
 */
public class QuickSort implements Sort{

    @Override
    public int[] sort(int[] unsorted) {
        quick_sort(unsorted, 0, unsorted.length);
        return unsorted;
    }

    private void quick_sort(int[] unsorted, int left, int right) {
        if (left > right) {
            return;
        }

        int i = left;
        int j = right;

        int temp = unsorted[i];
        while (i != j) {
            while (i < j && unsorted[j] > temp) {
                j --;
            }

            while (i < j && unsorted[i] < temp) {
                i ++;
            }
        }

        int kk = unsorted[left];
        unsorted[left] = unsorted[i];
        unsorted[i] = kk;

        quick_sort(unsorted,  left, i - 1);
        quick_sort(unsorted, right, i + 1);
    }
}
