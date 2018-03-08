package com.botany.mint.algorithm;

public class SortArray {

    // 交换排序之冒泡排序，第一遍排序把最小值放在unsorted[0]
    public static void bubble_sort(int[] unsorted) {
        for (int i = 0; i < unsorted.length - 1; i++) {
            for (int j = 0; j < unsorted.length - i - 1; j++) {
                if (unsorted[i] > unsorted[j]) {
                    int temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }
    }

    // 交换排序之快速排序  ？思考左为基准，先移动right的原因(相遇的值必须小于基准数値)
    public static void quick_sort(int[] a, int left, int right) {
        // 结束迭代
        if (left > right) {
            return;
        }

        int i = left;
        int j = right;

        int temp = a[left]; // 设置基准值，将最左端元素作为基准值

        while (i != j) {

            // 往左移，直到小于temp
            while (i < j && a[j] >= temp) {
                j--;
            }
            // 往右移，直到大于temp
            while (i < j && a[i] <= temp) {
                i++;
            }

            if (i < j) {
                int tt = a[i];
                a[i] = a[j];
                a[j] = tt;
            }
        }

        int kk = a[i];
        a[i] = temp;
        a[left] = kk;

        // 下一次迭代
        quick_sort(a, left, i - 1); // 左半边
        quick_sort(a, j + 1, right); // 右半边
    }

    // 插入排序之直接插入排序
    public static void insert_sort(int[] a) {
        for (int i = 1; i < a.length; i ++) {
            if (a[i] < a[i - 1]) {
                int j = i - 1;
                int x = a[i];
                a[i] = a[i - 1];
                while (x < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j+1] = x;
            }
        }
    }
    // 插入排序之希尔排序

    // 选择排序之简单选择排序

    // 选择排序之堆排序

    // 归并排序

    // 基数排序
}
