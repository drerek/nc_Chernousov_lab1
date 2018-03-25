package com.fillers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Random;

/**
 * This class is used to generation arrays with int data
 * @author Chernousov
 */
public class Fillers {
//    @Target(value= ElementType.METHOD)
//    @Retention(value = RetentionPolicy.RUNTIME)
//    public @interface Fillers{
//
//    }

    /**
     * private constructor for impossibility create object of class
     */
    private Fillers() {
    }

    /**
     * Method generate sortedArray
     *
     * @param length length of return array
     * @return sorted array
     */
    @GenerationArray
    public static int[] sortedMass(int length) {
        if (length>=0) {
            int a[] = new int[length];
            Random r = new Random();
            for (int i = 0; i < a.length; i++) {
                a[i] = r.nextInt();
            }
            Arrays.sort(a);
            return a;
        } else throw new NegativeArraySizeException();
    }

    /**
     * Method generate sorted array with random int in end
     *
     * @param length length of return array
     * @return sorted array with random int in end
     */
    @GenerationArray
    public static int[] sortedMassWithRand(int length) {
        if (length>0) {
            int a[] = sortedMass(length);
            a[length - 1] = new Random().nextInt();
            return a;
        }
        else if(length == 0){
            return new int[0];
        }
        else throw new NegativeArraySizeException();
    }

    /**
     * Method generate sorted array in opposite direction (from highest to lowest)
     *
     * @param length length of return array
     * @return sorted array from high to low
     */
    @GenerationArray
    public static int[] reverseMass(int length) {
        if (length >= 0) {
            int a[] = sortedMass(length);
            int b[] = new int[length];
            for (int i = 0; i < a.length; i++) {
                b[i] = a[length - 1 - i];
            }
            return b;
        } else throw new NegativeArraySizeException();
    }

    /**
     * Method generate array with random int
     *
     * @param length length of return array
     * @return random array
     */
    @GenerationArray
    public static int[] randMass(int length) throws NegativeArraySizeException{
        if (length >= 0) {
            int a[] = new int[length];
            Random r = new Random();
            for (int i = 0; i < a.length; i++) {
                a[i] = r.nextInt();
            }
            return a;
        } else throw new NegativeArraySizeException();
    }
}
