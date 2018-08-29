package com.vijay.study.easy.implementation;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

// https://www.hackerrank.com/challenges/strange-advertising/problem
public class StrangeAdvertisingTest {

    private final static Map<Integer, Integer> RESULT_MAP = new HashMap<>();

    static int viralAdvertising(int n) {
        return RESULT_MAP.computeIfAbsent(n, i -> computeLikesForDay(i));
    }

    private static int computeLikesForDay(final int n) {
        int currentDayLikes = computeLikedRecipentsForCurrentDay(5);
        int cumulativeLikes = currentDayLikes;
        for (int i = 1; i < n; i++) {
            final int sharedRecipents = computeSharedRecipentsForCurrentDay(currentDayLikes);
            currentDayLikes = computeLikedRecipentsForCurrentDay(sharedRecipents);
            cumulativeLikes = cumulativeLikes + currentDayLikes;
        }
        return cumulativeLikes;
    }

    private static int computeSharedRecipentsForCurrentDay(final int previousDayLikes) {
        return previousDayLikes * 3;
    }

    private static int computeLikedRecipentsForCurrentDay(final int sharedRecipents) {
        return sharedRecipents / 2;
    }

    @Test
    public void cummulativeLikesForDay1ShouldBeHalfOfShared() {
        executeAndAssert(1, 2);
    }

    @Test
    public void eachRecipentOfDay1ShouldShareWith3OnDay2AndAddToLikes() {
        executeAndAssert(2, 5);
    }

    @Test
    public void shouldAddOnToLikesForDay3ForSharingByDay2Recipents() {
        executeAndAssert(3, 9);
    }

    @Test
    public void shouldGiveCumulativeForDaysBEyond3() {
        executeAndAssert(4, 15);
        executeAndAssert(5, 24);
        executeAndAssert(6, 37);
    }


    private void executeAndAssert(final int dayNo, final int expectedCumulativeLikes) {
        assertThat(viralAdvertising(dayNo), equalTo(expectedCumulativeLikes));
    }
}
