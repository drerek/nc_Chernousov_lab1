package com.sorters;

public class BubbleSortFromEndToStart extends BubbleSort {
    @Override
    @OurMethod
    public void sort(int[] a) {
        for (int i=0;i<a.length-1;i++) {
            for (int j = a.length-1; j > i; j--) {
                if (a[j - 1] > a[j]) swap(a, j, j - 1);
            }
        }
    }
}
