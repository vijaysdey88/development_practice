package com.vijay.study.easy.implementation;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BirthdayBarTest {

    static int birthday(final List<Integer> barSquares, int d, int m) {
        final AtomicInteger ways = new AtomicInteger();
        IntStream.range(0, getMaxIndexToAnalyze(barSquares, m))
                 .forEach(checkIfMatchFound(barSquares, d, m, ways));
        return ways.get();
    }

    private static IntConsumer checkIfMatchFound(final List<Integer> barSquares, final int d, final int m, final AtomicInteger ways) {
        return i -> {
            Optional<Integer> total = computeTotal(barSquares, m, i);
            if(total.get() == d)
                ways.incrementAndGet();
        };
    }

    private static Optional<Integer> computeTotal(final List<Integer> barSquares, final int m, final int i) {
        return barSquares.subList(i, i + m).stream().reduce((i1, i2) -> i1 + i2);
    }

    private static int getMaxIndexToAnalyze(final List<Integer> barSquares, final int m) {
        return barSquares.size() - m + 1;
    }

    @Test
    public void shouldFind1WayOfSplittingForMonthOneForSingleSquareBar() {
        assertThat(1, equalTo(birthday(newArrayList(1), 1, 1)));
        assertThat(1, equalTo(birthday(newArrayList(4), 4, 1)));
    }

    @Test
    public void shouldFindNoWaysForMonthOne() {
        assertThat(0, equalTo(birthday(newArrayList(2), 1, 1)));
    }

    @Test
    public void shouldFind1WayOfSplittingForMonthOneForMultipleSquareBar() {
        verify(1, 1, 1, 1, 2, 3);
        verify(1, 1, 1, 2, 1, 3);
    }

    @Test
    public void shouldFindOneWayForGreaterThanOneMonth() {
        verify(2, 2, 1, 1, 1, 3);
        verify(3, 2, 1, 2, 1, 5);
        verify(3, 3, 1, 1, 1, 1);
    }


    @Test
    public void shouldFindMultipleWaysForMonthOne() {
        verify(3, 1, 2, 3, 3);
        verify(3, 1, 2, 3, 0, 3);
    }

    @Test
    public void shouldFindMultipleWaysForGreaterThanOneMonth() {
        verify(3, 2, 2, 1, 2, 1);
        verify(5, 3, 2, 2, 2, 1, 10, 2, 2, 1);
    }

    @Test
    public void shouldNotFindWaysWhenTotalNeededIsTooSmall() {
        verify(1, 3, 0, 1, 1, 1, 1);
    }

    @Test
    public void testHRInputs() {
        verify(3, 2, 2, 1,2,1,3,2);
        verify(4, 1, 1, 4, 1);
    }

    private void verify(final int d, final int m, final int expected, final Integer... integers) {
        assertThat(birthday(newArrayList(integers), d, m), equalTo(expected));
    }
}
