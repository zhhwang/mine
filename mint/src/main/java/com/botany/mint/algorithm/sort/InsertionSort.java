package com.botany.mint.algorithm.sort;

/**
 * 直接插入排序
 *
 * <pre>
 *     1. 每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去
 * </pre>
 * @author wangzh
 */
public class InsertionSort implements Sort{
    @Override
    public int[] sort(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            int j = i;
            while (j > 0 && unsorted[j] < unsorted[j - 1]) {
                swap(unsorted,j,j-1);
                j--;
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
