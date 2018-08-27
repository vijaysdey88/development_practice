package com.vijay.study.easy.implementation;

import java.util.Stack;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CountingValleysTest {

    static int countingValleys(int n, String s) {
        final Stack<Character> trail = new Stack<>();
        int valleysCount = 0;
        for (final Character nextStep : s.toCharArray()) {
            if(startNewDirectionOrContinuGoingInSameDirection(trail, nextStep)) {
                trail.push(nextStep);
                if(isFirstStepGoingDown(trail)) {
                    valleysCount++;
                }
            } else {
                trail.pop();
            }
        }
        return valleysCount;

    }

    private static boolean startNewDirectionOrContinuGoingInSameDirection(final Stack<Character> trail, final char nextStep) {
        return trail.isEmpty() || nextStep == trail.peek();
    }

    private static boolean isFirstStepGoingDown(final Stack<Character> trail) {
        return trail.size() == 1 && trail.firstElement() == 'D';
    }

    @Test
    public void shouldCountSingleValley() {
        assertThat(countingValleys(2, "DU"), equalTo(1));
        assertThat(countingValleys(4, "DDUU"), equalTo(1));
        assertThat(countingValleys(6, "DDDUUU"), equalTo(1));
    }

    @Test
    public void shouldCountTwoOrMoreValleys() {
        assertThat(countingValleys(4, "DUDU"), equalTo(2));
        assertThat(countingValleys(4, "DDUUDDUUDDUU"), equalTo(3));
    }

    @Test
    public void shouldCountOneValleyWithAMountain() {
        assertThat(countingValleys(4, "DUUD"), equalTo(1));
        assertThat(countingValleys(8, "DDUUUUDD"), equalTo(1));
        assertThat(countingValleys(4, "UDDU"), equalTo(1));
        assertThat(countingValleys(6, "UUDDDU"), equalTo(1));
    }

    @Test
    public void shouldCountAValleyInBetweenTwoMountains() {
        assertThat(countingValleys(4, "UDDUUD"), equalTo(1));
    }
}

