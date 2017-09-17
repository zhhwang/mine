package com.botany.mint.sort;

public class Sort {

    // 交换排序之冒泡排序，第一遍排序把最小值放在unsorted[0]
    public static void bubble_sort(int[] unsorted) {
        for (int i = 0; i < unsorted.length; i++) {
            for (int j = i; j < unsorted.length; j++) {
                if (i > j) {
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
}
