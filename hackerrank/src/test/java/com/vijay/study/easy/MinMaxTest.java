package com.vijay.study.easy;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MinMaxTest {
    
    @Test
    public void shouldGetMinOfFourOutOfFiveNumbers() {
        int[] input = new int[]{1, 2, 3, 4, 5};
        assertThat(min(input), equalTo(10));
    }

    @Test
    public void shouldGetMaxOfFourOutOfFiveNumbers() {
        int[] input = new int[]{1, 2, 3, 4, 5};
        assertThat(max(input), equalTo(14));
    }

    @Test
    public void testInput3() {
        int[] input = new int[]{426980153,354802167,142980735,968217435,734892650};
        assertThat(miniMaxSum(input), equalTo("1659655705 2484892405"));
    }

    static String miniMaxSum(int[] arr) {
        final String s = min(arr) + " " + max(arr);
        System.out.print(s);
        return s;
    }

    static long min(int[] arr) {
        return Arrays.stream(arr)
                .sorted()
                .limit(arr.length - 1)
                .mapToLong(Long::valueOf)
                .boxed()
                .collect(Collectors.summingLong(n -> n));
    }

    static long max(int[] arr) {
        return Arrays.stream(arr)
                .sorted()
                .skip(1)
                .limit(arr.length - 1)
                .mapToLong(Long::valueOf)
                .boxed()
                .collect(Collectors.summingLong(n -> n));
    }
}
