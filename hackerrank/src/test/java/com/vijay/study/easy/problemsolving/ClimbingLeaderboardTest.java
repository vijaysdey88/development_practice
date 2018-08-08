package com.vijay.study.easy.problemsolving;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ClimbingLeaderboardTest {

    @Before
    public void setup() {
        RANK_TO_INDEX = new LinkedHashMap<>();
    }

    @Test
    public void shouldBeFirstInManyExistingScores() {
        assertThat(rank(new int[]{ 20, 15, 10 }, 30, 4), equalTo(1));
    }

    @Test
    public void shouldBeLastInManyExistingScores() {
        assertThat(rank(new int[]{ 20, 15, 10 }, 5, 4), equalTo(4));
    }

    @Test
    public void shouldBeMiddleInManyExistingScores() {
        assertThat(rank(new int[]{ 20, 15, 10 }, 12, 4), equalTo(3));
        assertThat(rank(new int[]{ 20, 15, 10 }, 17, 4), equalTo(2));
    }

    @Test
    public void shouldBeBeRankedAsSameWhenScoreIsExactlyEqual() {
        assertThat(rank(new int[]{ 20, 15, 10 }, 15, 4), equalTo(2));
    }

    @Test @Ignore
    public void shouldConsiderSameScoresAsSameRank() {
        assertThat(rank(new int[]{ 20, 20 ,15, 15, 10, 10 }, 20, 4), equalTo(1));
        assertThat(rank(new int[]{ 20, 20 ,15, 15, 10, 10 }, 15, 4), equalTo(2));
        assertThat(rank(new int[]{ 20, 20, 15, 15, 10, 10 }, 10, 4), equalTo(3));
    }

    @Test
    public void shouldFindRanksForMultipleGamesPlayedByAlice() {
        final int[] scores = {100, 100, 50, 40, 40, 20, 10};
        final int[] alicesScores = {5, 25, 50, 120};

        final int[] result = climbingLeaderboard(scores, alicesScores);
        assertThat(result, equalTo(new int[]{6, 4, 2, 1}));
    }

    @Test
    public void shouldAlwaysBeFirstOnceFirst() {
        final int[] scores = {100, 50, 40, 20, 10};
        final int[] alicesScores = {30, 120, 130, 140, 160};

        final int[] result = climbingLeaderboard(scores, alicesScores);
        assertThat(result, equalTo(new int[]{4, 1, 1, 1, 1}));
    }

    @Test
    public void getTheLastRank() {
        assertThat(lastRank(new int[]{ 100, 50 }), equalTo(3));
        assertThat(lastRank(new int[]{ 100, 50, 50 }), equalTo(3));
    }

    private static Map<Integer, Integer> RANK_TO_INDEX;

    private static int[] climbingLeaderboard(final int[] scores, final int[] alice) {
        RANK_TO_INDEX = new LinkedHashMap<>();
        final int[] ranks = new int[alice.length];
        int[] uniqueScores = Arrays.stream(scores).distinct().toArray();
        int r = uniqueScores.length + 1;
        for (int i = 0; i < alice.length; i++) {
            r = rank(uniqueScores, alice[i], r);
            ranks[i] = r;
        }
        return ranks;
    }

    private static int rank(final int[] scores, final int playerScore, final int previousRank) {
        if(previousRank == 1)
            return 1;
        int rank = previousRank;
        int i = RANK_TO_INDEX.getOrDefault(previousRank, scores.length - 1);
        for (; i >= 0; i--) {
            final int score = scores[i];
            if(playerScore < score)
                break;
            if(playerScore >= scores[i])
              rank--;
        }
        RANK_TO_INDEX.put(rank, i < 0 ? 0 : i);
        return rank;
    }

    private static int lastRank(final int[] scores) {
        return Arrays.stream(scores).boxed().collect(Collectors.toSet()).size() + 1;
    }

    private static boolean consecutiveScoresAreEqual(final int[] scores, final int i) {
        return i == scores.length - 1 || scores[i]!= scores[i + 1];
    }


}