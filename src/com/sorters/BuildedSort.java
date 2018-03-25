package com.sorters;

import java.util.Arrays;

/**
 * Class that use builded sort {@link Arrays#sort(int[])}
 *
 * @author Chernousov
 */
public class BuildedSort extends Sort{

    /**
     * Method that uses {@link Arrays#sort(int[])}
     * @param a the array to be sorted
     */
    @Override
    @OurMethod
    public void sort(int[] a) {
        Arrays.sort(a);
    }
}
