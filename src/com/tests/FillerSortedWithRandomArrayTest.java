package com.tests;

import com.fillers.Fillers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FillerSortedWithRandomArrayTest {
    private static final int SIZE=10;

    @Test
    public void testSizeArray(){
        int[] numbers = Fillers.sortedMassWithRand(SIZE);
        assertEquals(SIZE,numbers.length);
        int length=0;
        for (int i: numbers){
            length++;
        }
        assertEquals(numbers.length,length);
    }

    @Test
    public void testZeroLengthArray(){
        int[] numbers = Fillers.sortedMassWithRand(0);
        assertEquals(numbers.length,0);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testException(){
        int[] number = Fillers.sortedMassWithRand(-5);
    }
}
