package com.sorters;

/**
 * This class is realization of abstract class {@link Sort}
 * This class realized QuickSort
 *
 * @author Chernousov
 */
public class QuickSort extends Sort {

    /**
     * Override method of abstract class that realize QuickSort
     * @param a the array to be sorted
     */
    @Override
    @OurMethod
    public void sort(int[] a) {
        quickSort(a,0,a.length-1);
    }

    /**
     * Recursive realization of Quick sort
     * @param a array what need to sort
     * @param lo low index of array {@code a}
     * @param hi high index of array {@code a}
     */
    private void quickSort(int[] a, int lo, int hi){
        if (lo<hi){
            int p = partSort(a,lo,hi);
            quickSort(a,lo,p-1);
            quickSort(a,p,hi);
        }
    }

    /**
     * Realization of part sort. Swap element around support element
     * @param a array in which we swapped
     * @param lo low index of array {@code a}
     * @param hi high index of array {@code a}
     * @return index of supported element
     */
    private int partSort(int[] a, int lo, int hi){
        int support = getSupport(a,lo,hi);
        int i = lo;
        int j= hi;
        while (i<=j){
            while (a[i]<support)i++;
            while (a[j]>support)j--;

            if (i<=j) {
                swap(a,i,j);
                i++;
                j--;

            }
        }
        return i;
    }

    /**
     * Method that return support element for QuickSort
     * @param a array in which we search support element
     * @param lo low index of array a
     * @param hi high index of array a
     * @return support element
     */
    private int getSupport(int a[], int lo, int hi){
        return a[(lo+hi)/2];
    }
}
