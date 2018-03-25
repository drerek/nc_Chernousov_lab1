package com.tests;

import com.fillers.Fillers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FillerRandomArrayTest {
    private static final int SIZE=10;

    @Test
    public void testSizeRandomArray(){
        int[] numbers = Fillers.randMass(SIZE);
        assertEquals(SIZE,numbers.length);
        int length=0;
        for (int i: numbers){
            length++;
        }
        assertEquals(numbers.length,length);
    }

    @Test
    public void testZeroLengthArray(){
        int[] numbers = Fillers.randMass(0);
        assertEquals(numbers.length,0);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testException(){
        int[] number = Fillers.randMass(-5);
    }
}
