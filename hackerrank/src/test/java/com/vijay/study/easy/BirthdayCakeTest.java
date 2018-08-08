package com.vijay.study.easy;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BirthdayCakeTest {

    @Test
    public void shouldNotBeAbleToBlowForEmptyInput() {
        assertThat(birthdayCakeCandles(new int[] {}), equalTo(0));
        assertThat(birthdayCakeCandles(null), equalTo(0));
    }

    @Test
    public void shouldBeAbleToBlowOnlyOneCandleWithGreatestHeight() {
        assertThat(birthdayCakeCandles(new int[] {2, 1}), equalTo(1));
        assertThat(birthdayCakeCandles(new int[] {1, 2}), equalTo(1));
    }

    @Test
    public void shouldBeAbleToBlowAllCandlesOfSameHeight() {
        assertThat(birthdayCakeCandles(new int[] {1, 1}), equalTo(2));
        assertThat(birthdayCakeCandles(new int[] {2, 2}), equalTo(2));
    }

    @Test
    public void shouldBeAbleToBlowCandlesMixedCandlesWithHighestHeigth() {
        assertThat(birthdayCakeCandles(new int[] {1, 2, 2}), equalTo(2));
        assertThat(birthdayCakeCandles(new int[] {2, 1, 2}), equalTo(2));
        assertThat(birthdayCakeCandles(new int[] {2, 2, 1}), equalTo(2));
        assertThat(birthdayCakeCandles(new int[] {3, 2, 1, 3}), equalTo(2));
    }

    static int birthdayCakeCandles(int[] ar) {
        if(ar == null || ar.length == 0)
            return 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            if(ar[i] > max) {
                max = ar[i];
                count = 0;
            }
            if(ar[i] == max) {
                count++;
            }
        }
        return count;
    };
}
