package com.vijay.study.medium.problemsolving;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static com.vijay.study.medium.problemsolving.CountTripletsJustCounts.countTriplets;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class CountTripletsJustCountsTest {

    @Test
    public void shouldCountForNonRepeatedTriplets(){
        final List<Long> input = list(1, 2, 4);

        assertThat(countTriplets(input, 2), equalTo(1l));
    }

    @Test
    public void shouldCountForRepeatedFirstNumberInTriplets(){
        final List<Long> input = list(1, 1, 2, 4);

        assertThat(countTriplets(input, 2), equalTo(2l));
    }

    @Test
    public void shouldCountForRepeatedSecondNumberInTriplets(){
        final List<Long> input = list(1, 2, 2, 4);

        assertThat(countTriplets(input, 2), equalTo(2l));
    }

    @Test
    public void shouldCountForRepeatedThirdNumberInTriplets(){
        final List<Long> input = list(1, 2, 4, 4);

        assertThat(countTriplets(input, 2), equalTo(2l));
    }


    @Test
    public void shouldExcludeCountForNotGeoMetricProgression(){
        final List<Long> input = list(1, 2, 4, 16);

        assertThat(countTriplets(input, 2), equalTo(1l));
    }

    @Test
    public void shouldCountForSuccessiveOverlappingTriplets(){
        final List<Long> input = list(1, 2, 4, 8);

        assertThat(countTriplets(input, 2), equalTo(2l));
    }

    @Test
    public void shouldCountForNonOverlappingGeoMetricProgression(){
        final List<Long> input = list(1, 2, 4, 16, 32, 64);


        assertThat(countTriplets(input, 2), equalTo(2l));
    }


    @Test
    public void testhr2(){
        final List<Long> input = list(1, 3, 9, 9, 27, 81);


        assertThat(countTriplets(input, 3), equalTo(6l));
    }

    @Test
    public void testhr3(){
        final List<Long> input = list(1, 5, 5, 25, 125);


        assertThat(countTriplets(input, 5), equalTo(4l));
    }

    @Test
    public void testhr4(){
        final List<Long> input = list(1, 2, 1, 2, 4);
        //1 1 2 2 4

        assertThat(countTriplets(input, 2), equalTo(3l));
    }


    private List<Long> list(long... inputs) {
        return LongStream.of(inputs).boxed().collect(Collectors.toList());
    }
}