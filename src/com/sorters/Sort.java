package com.sorters;

/**
 *
 * This class is abstract class with 2 methods. 1 abstract method is sort and static method swap
 *  @see BubbleSortFromEndToStart
 *  @see BubbleSortFromStartToEnd
 *  @see BuildedSort
 *  @see MergeSort
 *  @see QuickSort
 *
 *  @author Chernousov
 */
@ControlledObject(name="abstract")
public abstract class Sort {

    /**
     *
     * @param a the array to be sorted
     */
    public abstract void sort(int[] a);

    /**
     * Function that swaps a[i] and a[j]
     * @param a the array in which swapped
     * @param i first index of array
     * @param j second index of array
     */
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
