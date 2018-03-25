package com.tests;

import com.fillers.Fillers;
import com.sorters.BubbleSortFromEndToStart;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Tempuser on 01.11.2017.
 */
public class BubbleSortFromEndToStartTest {
    private int[] numbers;
    private final static int SIZE = 1100;

    @Before
    public void setUp(){
        numbers = Fillers.randMass(SIZE);
    }

    @Test
    public void testBubbleSortFromEnd(){
        long startTime = System.currentTimeMillis();
        BubbleSortFromEndToStart bubbleSortFromEndToStart = new BubbleSortFromEndToStart();
        bubbleSortFromEndToStart.sort(numbers);
        System.out.println("bubbleSortFromEndToStart sort time "+ (System.currentTimeMillis()-startTime));
        for (int i=0;i<numbers.length-1;i++){
            if (numbers[i] > numbers[i+1]){
                System.out.println(Arrays.toString(numbers));
                fail("Something wrond");

            }
        }
        assertTrue(true);
    }
}
