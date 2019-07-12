package com.vijay.study.easy.problemsolving;

import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class JesseAndCookiesTest {

    @Test
    public void shouldSuceedWithoutAttemptWhenFirstCookieIsGreaterThanEqualToThreshold(){
        verify(1, new int[]{1, 2, 3}, 0);
        verify(0, new int[]{1, 2, 3}, 0);
    }

    @Test
    public void shouldGiveCookieInSingleOperation(){
        int[] input = {1, 2, 4};
        verify(4, input, 1);
    }

    @Test
    public void shouldGiveCookieInputIsNotOrderedInSingleOperation(){
        int[] input = {1, 2, 4};
        verify(4, input, 1);
    }

    @Test
    public void shouldGiveCookiesIn2Operations(){
        verify(8, new int[]{1, 2, 3}, 2);
        verify(7, new int[]{1, 2, 3, 9, 10, 12}, 2);
        verify(11, new int[]{1, 2, 3, 11}, 2);
    }


    @Test
    public void shouldGiveCookiesTillLastElement(){
        verify(13, new int[]{1, 2, 3}, 2);
        verify(27, new int[]{1, 2, 3, 4}, 3);
    }

    @Test
    public void shouldGiveNotPossibeWhenThresholdCannotBeReached(){
        verify(14, new int[]{1, 2, 3}, -1);
        verify(28, new int[]{1, 2, 3, 4}, -1);
    }

    @Test
    public void shouldGiveNotPossibleWhenSingleSweetnessIsLessThanThreshold(){
        verify(2, new int[]{1}, -1);
    }

    @Test
    public void shouldGivePossibleWhenSingleSweetnessIsGreaterThanEqualToThreshold(){
        verify(2, new int[]{1}, -1);
    }

    @Test
    public void testHkTestCase3(){
        verify(90, new int[]{13, 47, 74, 12, 89, 74, 18, 38}, 5);

    }

    private void verify(int k, int[] input, int expected) {
        assertThat(JesseAndCookies.cookies(k, input), Matchers.equalTo(expected));
    }

}