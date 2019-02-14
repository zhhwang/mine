package com.botany.mint.algorithm.sort;

/**
 * 希尔排序
 * <pre>
 *     1. 记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
 *     随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 *     2. 插入排序
 *     3. 时间复杂度：O(n^(1.3—2))
 * </pre>
 * @author wangzh
 * @create 2018-12-06 19:24
 */
public class ShellSort implements Sort{
    @Override
    public int[] sort(int[] unsorted) {
        //增量gap，并逐步缩小增量
        for(int gap = unsorted.length/2; gap > 0; gap /= 2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<unsorted.length;i++){
                int j = i;
                while(j-gap>=0 && unsorted[j]<unsorted[j-gap]){
                    //插入排序采用交换法
                    swap(unsorted,j,j-gap);
                    j-=gap;
                }
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
