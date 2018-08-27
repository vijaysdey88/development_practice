package com.vijay.study.easy.implementation;

import java.util.stream.IntStream;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BeautifulDaysAtMoviesTest {

    static int beautifulDays(int i, int j, int k) {
        return (int) IntStream.rangeClosed(i, j)
                .map(n -> diffBetweenOriginalAndReverse(n))
                .filter(n -> isCompletelyDivisible(n, k))
                .count();
    }

    private static int reverse(final int original) {
        final String str = String.valueOf(original);
        final StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return Integer.valueOf(sb.toString());
    }

    private static int diffBetweenOriginalAndReverse(final int original) {
        return Math.abs(original - reverse(original));
    }

    private static boolean isCompletelyDivisible(final int number, final int divisor) {
        return number % divisor == 0;
    }


    @Test
    public void shouldGiveReverseOfANumber() {
        assertThat(reverse(1), equalTo(1));
        assertThat(reverse(12), equalTo(21));
        assertThat(reverse(123), equalTo(321));
        assertThat(reverse(10), equalTo(1));
    }

    @Test
    public void shouldFindDifferenceBetweenANumberAndItsReverse() {
        assertThat(diffBetweenOriginalAndReverse(1), equalTo(0));
        assertThat(diffBetweenOriginalAndReverse(21), equalTo(9));
        assertThat(diffBetweenOriginalAndReverse(12), equalTo(9));
    }

    @Test
    public void shouldFilterBasedWetherCompletelyDivisibleByDivisor() {
        assertThat(isCompletelyDivisible(3, 1), equalTo(true));
        ;
        assertThat(isCompletelyDivisible(3, 3), equalTo(true));
        ;
        assertThat(isCompletelyDivisible(3, 2), equalTo(false));
        ;
        assertThat(isCompletelyDivisible(3, 4), equalTo(false));
        ;
        assertThat(isCompletelyDivisible(0, 4), equalTo(true));
        ;
    }

    @Test
    public void shouldGiveCountOfBeautifulDaysForSingleDay() {
        assertThat(beautifulDays(1, 1, 1), equalTo(1));
        assertThat(beautifulDays(21, 21, 3), equalTo(1));
        assertThat(beautifulDays(21, 21, 6), equalTo(0));
    }

    @Test
    public void shouldGiveCountOfBeautifulDaysForARangeOfDays() {
        assertThat(beautifulDays(1, 2, 2), equalTo(2));
        assertThat(beautifulDays(10, 11, 2), equalTo(1));
        assertThat(beautifulDays(10, 13, 2), equalTo(2));
        assertThat(beautifulDays(20, 23, 2), equalTo(2));
    }
}
