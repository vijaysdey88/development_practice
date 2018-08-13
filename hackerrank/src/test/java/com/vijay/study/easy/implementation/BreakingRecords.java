package com.vijay.study.easy.implementation;

import java.util.stream.IntStream;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

//https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
public class BreakingRecords {

    static int[] breakingRecords(int... scores) {
        Recorder recorder = recordScores(scores);
        return new int[]{recorder.getMaxRecord(), recorder.getMinRecord()};
    }

    private static Recorder recordScores(final int[] scores) {
        final Recorder recorder = new Recorder(scores);
        IntStream.range(1, scores.length)
                 .forEach(recorder::record);
        return recorder;
    }

    private static class Recorder {
        private final int[] scores;
        private int minRecord;
        private int maxRecord;
        private int min;
        private int max;

        public Recorder(final int... scores) {
            this.scores = scores;
            if(scores.length > 0) {
                this.min = scores[0];
                this.max = scores[0];
            }
        }

        public int getMinRecord() {
            return minRecord;
        }

        public int getMaxRecord() {
            return maxRecord;
        }

        public void record(final int i) {
            if(scores[i] < min) {
                minRecord++;
                min = scores[i];
            }
            else if(scores[i] > max) {
                maxRecord++;
                max = scores[i];
            }
        }
    }

    @Test
    public void shouldHaveZeroRecordBreaksWhenNoGamesPlayed() {
        assertThat(breakingRecords(), equalTo(new int[]{0, 0}));
        assertThat(breakingRecords(new int[]{}), equalTo(new int[]{0, 0}));;
    }

    @Test
    public void shouldHaveZeroRecordsWhenOnlyOneGameIsPlayed() {
        assertThat(breakingRecords(1), equalTo(new int[]{0, 0}));
    }

    @Test
    public void shouldRecordMinScoreForTwoGames() {
        assertThat(breakingRecords(1, 0), equalTo(new int[]{0, 1}));
    }

    @Test
    public void shouldRecordMaxScoreForTwoGames() {
        assertThat(breakingRecords(0, 1), equalTo(new int[]{1, 0}));
    }

    @Test
    public void shouldNotRecordWhenScoresAreSameForTwoGames() {
        assertThat(breakingRecords(0, 0), equalTo(new int[]{0, 0}));
    }

    @Test
    public void shouldComputeMinScoresForMultipleGames() {
        assertThat(breakingRecords(3, 2, 1, 0), equalTo(new int[]{0, 3}));
        assertThat(breakingRecords(3, 2, 2, 1, 1, 0), equalTo(new int[]{0, 3}));
        assertThat(breakingRecords(3, 2, 3, 3, 1), equalTo(new int[]{0, 2}));
    }

    @Test
    public void shouldComputeMaxScoresForMultipleGames() {
        assertThat(breakingRecords(0, 1, 2, 3), equalTo(new int[]{3, 0}));
        assertThat(breakingRecords(0, 1, 1, 2, 2, 3), equalTo(new int[]{3, 0}));
    }

    @Test
    public void shouldRecordMinAndMaxForMultipleGames() {
        assertThat(breakingRecords(3, 2, 4), equalTo(new int[]{1, 1}));
    }

    @Test
    public void testHRInputs() {
        assertThat(breakingRecords(10, 5, 20, 20, 4, 5, 2, 25, 1), equalTo(new int[]{2, 4}));
    }
}
