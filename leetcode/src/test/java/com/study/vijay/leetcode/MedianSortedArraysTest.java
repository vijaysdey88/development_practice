package com.study.vijay.leetcode;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class MedianSortedArraysTest {

    private final MedianSortedArrays solution = new MedianSortedArrays();

    @Test
    public void shouldFindMedianForOrderedFirstAndSecondArraySize3(){
        verify(new int[]{1, 2}, new int[]{3}, 2);
        verify(new int[]{3}, new int[]{1, 2}, 2);
    }

    @Test
    public void shouldFindMedianForUnOrderedFirstAndSecondArraySize3(){
        verify(new int[]{1, 3}, new int[]{2}, 2);
        verify(new int[]{2}, new int[]{1, 3}, 2);
    }

    @Test
    public void shouldFindMedianForOddSizedMergedArray(){
        verify(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6}, 4);
    }

    @Test
    public void shouldFindMedianForMergedArraySize2() {
        verify(new int[]{1}, new int[]{2}, 1.5);
        verify(new int[]{2}, new int[]{1}, 1.5);
    }

    @Test
    public void shouldFindMedianForEvenSizedMergedArray(){
        verify(new int[]{1, 3}, new int[]{2, 4}, 2.5);
        verify(new int[]{2, 4}, new int[]{1, 3}, 2.5);
        verify(new int[]{1, 3, 5, 7}, new int[]{2, 4, 8, 9}, 4.5);
    }


    @Test
    public void shouldFindMedianForUnOrderedFirstAndSecondArraySize5(){
        verify(new int[]{1, 3, 5},new int[]{2, 4}, 3);
    }

    @Test
    public void shouldHandleMedianOverflowingIntoSecondArray(){
        verify(new int[]{1},new int[]{2, 3}, 2);
        verify(new int[]{1},new int[]{2, 3, 4}, 2.5);
        verify(new int[]{1},new int[]{2, 3, 4, 5, 6, 7}, 4);
        verify(new int[]{1},new int[]{2, 3, 4, 5, 6}, 3.5);
    }

    @Test
    public void shouldHandleMedianOverflowingIntoFirstArray(){
        verify(new int[]{2, 3}, new int[]{1},2);
        verify(new int[]{2, 3, 4},new int[]{1}, 2.5);
        verify(new int[]{2, 3, 4, 5, 6, 7},new int[]{1}, 4);
        verify(new int[]{2, 3, 4, 5, 6}, new int[]{1},3.5);
    }

    @Test
    public void cheatTestForEmptyInputs1(){
        verify(new int[]{},new int[]{1}, 1);
    }

    @Test
    public void cheatTestForEmptyInputs2(){
        verify(new int[]{1},new int[]{}, 1);
    }

    private void verify(int[] n1, int[] n2, double exp) {
        Assert.assertThat(solution.findMedianSortedArrays(n1, n2), Matchers.equalTo(exp));
    }
}