package com.vijay.study.easy.implementation;

import java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PickingNumbersTest {

    static int pickingNumbers(int[] a) {
        int[] sorted = Arrays.copyOf(a, a.length);
        Arrays.sort(sorted);
        int maxLength = 0;
        for (int i = 0; i < a.length; ) {
            int currentSetStart = sorted[i];
            int currentSetLength = 0;
            int j = i;
            while(j < a.length && sorted[j] - currentSetStart <= 1) {
                j++;
                currentSetLength++;
            }
            i = j;
            if(currentSetLength > maxLength)
                maxLength = currentSetLength;
        }
        return maxLength;
    }

    @Test
    public void shouldReturnMaxLengthForSingleSetOfSmallestIdenticalElements() {
        verify(2, 1, 1);
        verify(3, 1, 1, 1);
        verify(3, 1, 1, 1, 3);
        verify(3, 10, 1, 1, 1, 20);
        verify(3, 10, 1, 20, 1, 30, 1);
    }

    @Test
    public void shouldReturnMaxLengthForSingleSetWithDifferenceLessThanOne() {
        verify(2, 1, 2);
        verify(3, 2, 1, 2);
    }

    @Test
    public void shouldReturnMaxLengthForSingleSetForGreaterValue() {
        verify(2, 1, 3, 3);
        verify(2, 1, 3, 3, 1);
    }

    @Test
    public void shouldReturnMaxForMixedSets() {
        verify(3, 1, 3, 4, 5, 1, 2);
        verify(4, 4, 1, 3, 4, 5, 1, 2, 4);
    }

    @Test
    public void testHRInput() {
        verify(3, 4, 6, 5, 3, 3, 1);
        verify(5, 1, 2, 2, 3, 1, 2);
    }

    private void verify(final int expected, final int... inputs) {
        assertThat("Incorrect result for " + Arrays.toString(inputs), pickingNumbers(inputs), equalTo(expected));
    }
}
