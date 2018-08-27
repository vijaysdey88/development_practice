package com.vijay.study.easy.implementation;

import java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

//https://www.hackerrank.com/challenges/electronics-shop/problem
public class ElectronicShopTest {

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        final Integer[] sortedKeyboards = sortedCosts(keyboards);
        final Integer[] sortedDrives = sortedCosts(drives);
        int estimate = -1;
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                final int nextExtimate = sortedKeyboards[i] + sortedDrives[j];
                if( nextExtimate <= b) {
                    estimate = Math.max(nextExtimate, estimate);
                }
            }
        }
        return estimate;
    }

    private static Integer[] sortedCosts(final int[] costs) {
        return Arrays.stream(costs).boxed()
                .sorted((i1, i2) -> i2 - i1)
                .toArray((i) -> new Integer[i]);
    }

    @Test
    public void shouldGetMoneySpentWHenSingleKeyboardAndDriveAvailableIsExactlyEqualToBudget() {
        verify(2, new int[]{ 1 }, new int[]{ 1 }, 2);
        verify(3, new int[]{ 1 }, new int[]{ 2 }, 3);
    }

    @Test
    public void shouldGetMoneySpentWHenSingleKeyboardAndDriveAvailableWithinTheBudget() {
        verify(3, new int[]{ 1 }, new int[]{ 1 }, 2);
        verify(4, new int[]{ 1 }, new int[]{ 2 }, 3);
        verify(4, new int[]{ 2 }, new int[]{ 1 }, 3);
    }

    @Test
    public void shouldNotBeAbleToPurchaseWhenEitherBudgetNotEnoughForSingleOptions() {
        verify(2, new int[]{ 3 }, new int[]{ 1 }, -1);
        verify(2, new int[]{ 1 }, new int[]{ 3 }, -1);
        verify(3, new int[]{ 2 }, new int[]{ 2 }, -1);
    }

    @Test
    public void shouldSelectCostliestSingleKeyboardAndMultipleOptionsOfDrivesAvailable() {
        verify(3, new int[]{ 1 }, new int[]{ 1, 2 }, 3);
        verify(3, new int[]{ 1 }, new int[]{ 2, 1 }, 3);
        verify(4, new int[]{ 1 }, new int[]{ 1, 2, 3 }, 4);
        verify(4, new int[]{ 1 }, new int[]{ 1, 4, 3 }, 4);
    }

    @Test
    public void shouldNotBeAbleToPurchaseWhenEitherBudgetNotEnoughForMultipleOptions() {
        verify(3, new int[]{ 2 }, new int[]{ 2, 3 }, -1);
        verify(3, new int[]{ 2, 3 }, new int[]{ 2 }, -1);
    }

    @Test
    public void shouldSelectCostliestSingleDrivedAndMultipleOptionsOfKeyboardsAvailable() {
        verify(3, new int[]{ 1, 2 }, new int[]{ 1 }, 3);
        verify(4, new int[]{ 1, 2, 3 }, new int[]{ 1 }, 4);
    }

    @Test
    public void testHRInput() {
        verify(10, new int[]{ 3, 1 }, new int[]{ 5, 2, 8 }, 9);
        verify(5, new int[]{ 4 }, new int[]{ 5 }, -1);
    }

    private void verify(final int budget, final int[] keyboards, final int[] drives, final int expected) {
        assertThat(getMoneySpent(keyboards, drives, budget), equalTo(expected));
    }
}
