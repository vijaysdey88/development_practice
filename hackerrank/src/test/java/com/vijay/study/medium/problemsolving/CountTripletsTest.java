package com.vijay.study.medium.problemsolving;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class CountTripletsTest {

    @Test
    public void shouldCountForNonRepeatedTriplets(){
        final List<Long> input = list(1, 2, 4);

        final List<List<Long>> triplets = CountTriplets.triplets(input, 2);

        assertThat(triplets, hasSize(1));
        assertThat(triplets.get(0), equalTo((list(1, 2, 4))));
    }

    @Test
    public void shouldCountForRepeatedFirstNumberInTriplets(){
        final List<Long> input = list(1, 1, 2, 4);

        final List<List<Long>> triplets = CountTriplets.triplets(input, 2);

        assertThat(triplets, hasSize(2));
        assertThat(triplets.get(0), equalTo((list(1, 2, 4))));
        assertThat(triplets.get(1), equalTo((list(1, 2, 4))));
    }

    @Test
    public void shouldCountForRepeatedSecondNumberInTriplets(){
        final List<Long> input = list(1, 2, 2, 4);

        final List<List<Long>> triplets = CountTriplets.triplets(input, 2);

        assertThat(triplets, hasSize(2));
        assertThat(triplets.get(0), equalTo((list(1, 2, 4))));
        assertThat(triplets.get(1), equalTo((list(1, 2, 4))));
    }

    @Test
    public void shouldCountForRepeatedThirdNumberInTriplets(){
        final List<Long> input = list(1, 2, 4, 4);

        final List<List<Long>> triplets = CountTriplets.triplets(input, 2);

        assertThat(triplets, hasSize(2));
        assertThat(triplets.get(0), equalTo((list(1, 2, 4))));
        assertThat(triplets.get(1), equalTo((list(1, 2, 4))));
    }


    @Test
    public void shouldExcludeCountForNotGeoMetricProgression(){
        final List<Long> input = list(1, 2, 4, 16);

        final List<List<Long>> triplets = CountTriplets.triplets(input, 2);

        assertThat(triplets, hasSize(1));
        assertThat(triplets.get(0), equalTo((list(1, 2, 4))));
    }

    @Test
    public void shouldCountForSuccessiveOverlappingTriplets(){
        final List<Long> input = list(1, 2, 4, 8);

        final List<List<Long>> triplets = CountTriplets.triplets(input, 2);

        assertThat(triplets, hasSize(2));
        assertThat(triplets.get(0), equalTo((list(1, 2, 4))));
        assertThat(triplets.get(1), equalTo((list(2, 4, 8))));
    }

    @Test
    public void shouldCountForNonOverlappingGeoMetricProgression(){
        final List<Long> input = list(1, 2, 4, 16, 32, 64);

        final List<List<Long>> triplets = CountTriplets.triplets(input, 2);

        assertThat(triplets, hasSize(2));
        assertThat(triplets.get(0), equalTo((list(1, 2, 4))));
        assertThat(triplets.get(1), equalTo((list(16, 32, 64))));
    }


    @Test
    public void testhr2(){
        final List<Long> input = list(1, 3, 9, 9, 27, 81);

        final List<List<Long>> triplets = CountTriplets.triplets(input, 3);

        assertThat(triplets, hasSize(6));
        assertThat(triplets.get(0), equalTo((list(1, 3, 9))));
        assertThat(triplets.get(1), equalTo((list(1, 3, 9))));
        assertThat(triplets.get(2), equalTo((list(3, 9, 27))));
        assertThat(triplets.get(3), equalTo((list(3, 9, 27))));
        assertThat(triplets.get(4), equalTo((list(9, 27, 81))));
        assertThat(triplets.get(5), equalTo((list(9, 27, 81))));
    }

    @Test
    public void testhr3(){
        final List<Long> input = list(1, 5, 5, 25, 125);

        final List<List<Long>> triplets = CountTriplets.triplets(input, 5);

        assertThat(triplets, hasSize(4));
    }

    @Test
    public void testhr4(){
        final List<Long> input = list(1, 2, 1, 2, 4);
        //1 1 2 2 4

        assertThat(CountTriplets.countTriplets(input, 2), equalTo(3l));
    }


    private List<Long> list(long... inputs) {
        return LongStream.of(inputs).boxed().collect(Collectors.toList());
    }

}