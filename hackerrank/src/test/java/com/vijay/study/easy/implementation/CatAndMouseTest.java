package com.vijay.study.easy.implementation;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

//https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
public class CatAndMouseTest {

    static String catAndMouse(int x, int y, int z) {
        final int distCatA = dist(x, z);
        final int distCatB = dist(y, z);
        if(distCatA == distCatB) {
            return "Mouse C";
        }
        if(distCatA < distCatB) {
            return "Cat A";
        }
        return "Cat B";
    }

    private static int dist(final int x, final int z) {
        return Math.abs(z - x);
    }

    @Test
    public void catAShouldReachMouseFirst() {
        evaluate(2, 1, 3, "Cat A");
        evaluate(2, 3, 1, "Cat A");
    }

    @Test
    public void catBShouldReachMouseFirst() {
        evaluate(1, 2, 3, "Cat B");
        evaluate(3, 2, 1, "Cat B");
    }

    @Test
    public void mouseShoulExcapeIfBothCatsReachTogetherAndStartFighting() {
        evaluate(1, 1, 2, "Mouse C");
        evaluate(1, 3, 2, "Mouse C");
    }

    private void evaluate(final int catA, final int catB, final int mouseC, final String expected) {
        assertThat(expected, equalTo(catAndMouse(catA, catB, mouseC)));
    }
}
