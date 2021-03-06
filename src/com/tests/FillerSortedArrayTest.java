package com.tests;

import com.fillers.Fillers;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FillerSortedArrayTest {
    private static final int SIZE=10;

    @Test
    public void testSizeArray(){
        int[] numbers = Fillers.sortedMass(SIZE);
        assertEquals(SIZE,numbers.length);
        int length=0;
        for (int i: numbers){
            length++;
        }
        assertEquals(numbers.length,length);
    }

    @Test
    public void testZeroLengthArray(){
        int[] numbers = Fillers.sortedMass(0);
        assertEquals(numbers.length,0);
    }

    @Test
    public void testSortedArray(){
        int[] numbers = Fillers.sortedMass(SIZE);
        for (int i=0;i<numbers.length-1;i++){
            if (numbers[i] > numbers[i+1]){
                System.out.println(Arrays.toString(numbers));
                fail("Something wrond");
            }
        }
    }

    @Test(expected = NegativeArraySizeException.class)
    public void testException(){
        int[] number = Fillers.sortedMass(-5);
    }
}
