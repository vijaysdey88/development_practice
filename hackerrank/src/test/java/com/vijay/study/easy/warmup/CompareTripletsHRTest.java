package com.vijay.study.easy.warmup;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CompareTripletsHRTest {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aScore = 0;
        int bScore = 0;
        final int ratingsCount = a.size();
        for (int i = 0; i < ratingsCount; i++) {
            Integer alexRating = a.get(i);
            Integer bobRating = b.get(i);
            if(alexRating > bobRating) {
                aScore++;
            }
            if(alexRating < bobRating) {
                bScore++;
            };
        }
        final List<Integer> scores = new ArrayList<>();
        scores.add(aScore);
        scores.add(bScore);
        return scores;
    }



    @Test
    public void shouldReturn0PointsWhenEqualScoreForSingleCrieria() {
       assertThat(compareTriplets(newArrayList(0), newArrayList(0)), equalTo(newArrayList(0, 0)));
    }

    @Test
    public void shouldGiveAlexOnePointWhenScoreForSingleCrieria() {
        assertThat(compareTriplets(newArrayList(1), newArrayList(0)), equalTo(newArrayList(1, 0)));
    }

    @Test
    public void shouldGiveBobOnePointWhenScoreForSingleCrieria() {
        assertThat(compareTriplets(newArrayList(0), newArrayList(1)), equalTo(newArrayList(0, 1)));
    }

    @Test
    public void shouldComputeScoreForTwoRatings() {
        assertThat(compareTriplets(newArrayList(1, 1), newArrayList(0, 0)), equalTo(newArrayList(2, 0)));
        assertThat(compareTriplets(newArrayList(0, 0), newArrayList(1, 1)), equalTo(newArrayList(0, 2)));
        assertThat(compareTriplets(newArrayList(1, 0), newArrayList(0, 1)), equalTo(newArrayList(1, 1)));
    }

    @Test
    public void shouldComputeScoreForThreeRatings() {
        assertThat(compareTriplets(newArrayList(1, 1, 1), newArrayList(0, 0, 0)), equalTo(newArrayList(3, 0)));
        assertThat(compareTriplets(newArrayList(0, 0, 0), newArrayList(1, 1, 1)), equalTo(newArrayList(0, 3)));
        assertThat(compareTriplets(newArrayList(1, 0, 0), newArrayList(0, 1, 0)), equalTo(newArrayList(1, 1)));
    }

    @Test
    public void shouldComputeScoreForHRSamples() {
        assertThat(compareTriplets(newArrayList(5, 6, 7), newArrayList(3, 6, 10)), equalTo(newArrayList(1, 1)));
        assertThat(compareTriplets(newArrayList(17, 28, 30), newArrayList(99, 16, 8)), equalTo(newArrayList(2, 1)));
    }
}
