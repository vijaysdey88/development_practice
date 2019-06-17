package com.study.vijay.leetcode;

import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class UniqueTripletsTest {

    private final UniqueTriplets solution = new UniqueTriplets();

    @Test()
    public void shouldGiveSingleTripleofOneNegativeAndTwoPostiveNumbers(){
        executeForSingleTriplet(Lists.newArrayList(), 0, -1, 1);
    }

    private void executeForSingleTriplet(List<Integer> expected, int ... inputs) {
        final List<List<Integer>> result = solution.threeSum(inputs);
        assertThat(result, hasSize(1));
        assertEquals(expected, result.get(0));
    }


}