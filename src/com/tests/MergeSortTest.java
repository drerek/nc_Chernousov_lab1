package com.tests;

import com.fillers.Fillers;
import com.sorters.MergeSort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class MergeSortTest {
    private int[] numbers;
    private final static int SIZE = 1100;

    @Before
    public void setUp(){
    numbers = Fillers.randMass(SIZE);
    }

    @Test
    public void testMergeSort(){
        long startTime = System.currentTimeMillis();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(numbers);
        System.out.println("MergeSort time "+ (System.currentTimeMillis()-startTime));
        for (int i=0;i<numbers.length-1;i++){
            if (numbers[i] > numbers[i+1]){
                fail("Something wrond");
            }
        }
        assertTrue(true);
    }
}
