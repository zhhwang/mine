package com.botany.mint.sort;

import com.botany.mint.algorithm.SortArray;
import org.junit.Test;

public class SortTest {

    @Test
    public void quick_sort_test() {
        int a[] = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        SortArray.quick_sort(a, 0, 9);
        for (int i = 0; i < a.length; i ++) {
            System.out.println(a[i]);
        }
    }

}
