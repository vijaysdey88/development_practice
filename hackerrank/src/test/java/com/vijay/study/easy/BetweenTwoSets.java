package com.vijay.study.easy;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class BetweenTwoSets {


    @Test
    public void shouldGetFactorWhenSetBContainsOnlyOnePrimeNumber() {
        assertThat(factorsOfB(new int[]{2}), equalTo(getExpected(1, 2)));
        assertThat(factorsOfB(new int[]{3}), equalTo(getExpected(1, 3)));
        assertThat(factorsOfB(new int[]{97}), equalTo(getExpected(1, 97)));
    }

    @Test
    public void shouldGetFactorWhenSetBContainsOnlyOneNonPrimeNumber() {
        assertThat(factorsOfB(new int[]{4}), equalTo(getExpected(1, 2, 4)));
        assertThat(factorsOfB(new int[]{6}), equalTo(getExpected(1, 2, 3, 6)));
    }

    @Test
    public void shouldGetFactorWhenSetBHasMultipleNumbers() {
        assertThat(factorsOfB(new int[]{4, 8, 16}), equalTo(getExpected(1, 2, 4)));
        assertThat(factorsOfB(new int[]{16, 32, 96}), equalTo(getExpected(1, 2, 4, 8, 16)));
    }

    @Test
    public void shouldGet1WhenNoCommonFactors() {
        assertThat(factorsOfB(new int[]{3, 5, 7}), equalTo(getExpected(1)));
    }

    @Test
    public void shouldGetCommonFactorsBetweenAAndB() {
        assertThat(getCommon(new int[]{2}, new int[]{2}), equalTo(getExpected(2)));
        assertThat(getCommon(new int[]{2 , 3}, new int[]{6, 12, 18, 36}), equalTo(getExpected(6)));
        assertThat(getCommon(new int[]{2 , 4}, new int[]{16, 32, 96}), equalTo(getExpected(4, 8, 16)));
    }

    @Test
    public void shouldGetEmptyWhenNoCommonFactor() {
        assertThat(getCommon(new int[]{2}, new int[]{3}), equalTo(getExpected()));
    }

    @Test
    public void shouldGiveSizeOfTheCommonFactors() {
        assertThat(getTotalX(new int[]{2 , 4}, new int[]{16, 32, 96}), equalTo(3));
    }
    
    @Test
    public void testCase4HR() {
        assertThat(factorsOfB(new int[]{100}), equalTo(getExpected(1, 2, 4, 5, 10, 20, 25, 50, 100)));
        assertThat(getTotalX(new int[]{1}, new int[]{100}), equalTo(9));
    }

    private TreeSet<Integer> getExpected(final Integer... integers) {
        return Sets.newTreeSet(Lists.newArrayList(integers));
    }

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        return getCommon(a, b).size();
    }

    /*
     * Complete the getTotalX function below.
     */
    static Set<Integer> getCommon(int[] a, int[] b) {
        final Set<Integer> factorsB = factorsOfB(b);
        final Set<Integer> commonFactor = new TreeSet<>();

        for (final Integer fb: factorsB){
            final boolean allDivided = IntStream.of(a)
                    .allMatch(i -> fb.intValue() % i == 0);
            if(allDivided)
                commonFactor.add(fb);
        }
        return commonFactor;
    }

    private static Set<Integer> factorsOfB(final int[] b) {
        Set<Integer> commonFactors = new TreeSet<>();
            int mulitiplier = 1;
            final AtomicInteger factor = new AtomicInteger(1);
            while(factor.get() <= b[0]) {
                final boolean allDivided = IntStream.of(b)
                        .allMatch(i -> i % factor.get() == 0);
                if(allDivided) {
                    commonFactors.add(factor.get());
                }
                mulitiplier++;
                factor.set(mulitiplier);
            }
        return commonFactors;
    }
}
