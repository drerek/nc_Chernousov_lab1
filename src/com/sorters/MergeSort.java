package com.sorters;

/**
 * This class is realization of abstract class {@link Sort}
 * This class realized Merge sort
 *
 * @author Chernousov
 */
public class MergeSort extends Sort {
    /**
     * Override method of abstract class that realize Merge sort
     * @param a the array to be sorted
     */
    @Override
    @OurMethod
    public void sort(int[] a) {
    mergeSort(a,0,a.length);
    }

    /**
     * Merges arrays
     * @param a the array
     * @param left
     * @param right
     */
    private void merge(int[] a, int left, int right){
        int mid = (left+right)/2;
        int[] result = new int[right - left];
        int it1 = 0;
        int it2 = 0;

        while (left+it1 < mid && mid+it2 < right){
            if (a[left+it1]<a[mid+it2]){
                result[it1+it2]=a[left+it1];
                it1++;
            }
            else{
                result[it1+it2]=a[mid+it2];
                it2++;
            }
        }
        while (left+it1<mid){
            result[it1+it2] = a[left+it1];
            it1++;
        }
        while (mid+it2<right){
            result[it1+it2] = a[mid+it2];
            it2++;
        }

        System.arraycopy(result, 0, a, left, it1 + it2);


    }

    /**
     * Recursive realization of mergeSort
     * @param a
     * @param left
     * @param right
     */
    private void mergeSort(int a[],int left, int right){
        if (left+1 >=right) return;
        int mid = (left+right)/2;
        mergeSort(a,left,mid);
        mergeSort(a,mid,right);
        merge(a,left,right);
    }
}
