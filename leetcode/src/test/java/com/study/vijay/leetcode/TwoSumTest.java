package com.study.vijay.leetcode;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    @Test()
    public void shouldReturnSumFor2Elements(){
        verify(new int[]{1, 2}, new int[]{0, 1}, 3);
    }

    @Test()
    public void shouldReturnFor3Elements(){
        final int[] input = {3, 4, 5};
        verify(input, new int[]{0, 1}, 7);
        verify(input, new int[]{0, 2}, 8);
        verify(input, new int[]{1, 2}, 9);
    }

    @Test()
    public void shouldNotCountAnElementItself(){
        verify(new int[]{3, 2, 4}, new int[]{1, 2}, 6);
    }


    @Test()
    public void shouldFindWhenBothInPairAreSame(){
        verify(new int[]{3,3}, new int[]{0, 1}, 6);
    }

    private void verify(int[] input, int[] expected, int target) {
        Assert.assertThat(TwoSum.twoSum(input, target), CoreMatchers.is(expected));
    }

}