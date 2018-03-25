package com.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({QuickSortTest.class,
        MergeSortTest.class,
        BuildedSortTest.class,
        BubbleSortFromEndToStartTest.class,
        BubbleSortFromStartToEndTest.class,
        FillerRandomArrayTest.class,
        FillerReverseArrayTest.class,
        FillerSortedArrayTest.class,
        FillerSortedWithRandomArrayTest.class})
public class TestSuite {
}
