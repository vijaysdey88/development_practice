package com.vijay.study.easy.warmup;

import com.google.common.collect.Lists;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CompareTripletsTest {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        final int ratingsCount = a.size();
        Pair<Integer, Integer> scores = computeScore(a, b, Pair.of(0, 0), ratingsCount, 0);
        return Lists.newArrayList(scores.getLeft(), scores.getRight());
    }

    private static Pair<Integer, Integer> computeScore(final List<Integer> a, final List<Integer> b, Pair<Integer, Integer> existingScore, final int ratingsCount, final int ratingIndex) {
        if(ratingIndex >= ratingsCount)
            return existingScore;

        final Pair<Integer, Integer> newScore = computeScoreForGivenRating(existingScore, a.get(ratingIndex), b.get(ratingIndex));
        return computeScore(a, b, newScore, ratingsCount, ratingIndex + 1);
    }

    private static Pair<Integer, Integer> computeScoreForGivenRating(Pair<Integer, Integer> scores, final Integer alexRating, final Integer bobRating) {
        if(alexRating > bobRating) {
            return Pair.of(scores.getLeft() + 1, scores.getRight());
        }
        if(alexRating < bobRating) {
            return Pair.of(scores.getLeft(), scores.getRight() + 1);
        }
        return Pair.of(scores.getLeft(), scores.getRight());
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
