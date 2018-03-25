package com.tests;

import com.fillers.Fillers;
import com.sorters.QuickSort;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Tempuser on 01.11.2017.
 */
public class QuickSortTest {
    private int[] numbers;
    private final static int SIZE = 1100;

    @Before
    public void setUp(){
        numbers = Fillers.randMass(SIZE);
    }

    @Test
    public void testQuickSort(){
        long startTime = System.currentTimeMillis();
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        System.out.println("Quick sort time "+ (System.currentTimeMillis()-startTime));
        for (int i=0;i<numbers.length-1;i++){
            if (numbers[i] > numbers[i+1]){
                System.out.println(Arrays.toString(numbers));
                fail("Something wrond");

            }
        }
        assertTrue(true);
    }


    @After
    public void testArraySizeAfterSort(){
        assertEquals(numbers.length,SIZE);
    }
}
