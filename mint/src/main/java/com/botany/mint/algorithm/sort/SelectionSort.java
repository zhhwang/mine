package com.botany.mint.algorithm.sort;

/**
 * 简单选择排序
 * <pre>
 *     1. 遍历一遍后获取到最小值的位置，交换到前面
 * </pre>
 * @author wangzh
 */
public class SelectionSort implements Sort {
    @Override
    public int[] sort(int[] unsorted) {

        for (int i = 0; i < unsorted.length; i ++) {
            int min = i;
            for (int j=i+1; j< unsorted.length;j++) {
                if (unsorted[j]<unsorted[min]) {
                    min = j;
                }
            }

            if (min != i) {
                swap(unsorted, min, i);
            }
        }
        return unsorted;
    }

    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}
