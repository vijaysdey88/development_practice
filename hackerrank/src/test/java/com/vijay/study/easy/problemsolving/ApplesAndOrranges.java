package com.vijay.study.easy.problemsolving;

import java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ApplesAndOrranges {

    @Test
    public void shouldGetThePointWhereTheFruitFell() {
        assertThat(fruitFallPoint(4, -1), equalTo(3));
        assertThat(fruitFallPoint(4, 1), equalTo(5));
        assertThat(fruitFallPoint(4, 0), equalTo(4));
    }

    @Test
    public void shouldIndicateWetherTheFruitFellOnTheHouse() {
        int houseStartPoint = 3;
        int houseEndPoint = 5;

        assertThat(hasFallenOnTheHouse(3, 5, 4), equalTo(true));
        assertThat(hasFallenOnTheHouse(3, 5, 3), equalTo(true));
        assertThat(hasFallenOnTheHouse(3, 5, 5), equalTo(true));

        assertThat(hasFallenOnTheHouse(3, 5, 2), equalTo(false));
        assertThat(hasFallenOnTheHouse(3, 5, 6), equalTo(false));
    }

    @Test
    public void shouldComputeFruitfallAndIndicateWetherItFellOnHouseForAAFruit() {
        int houseStartPoint = 3;
        int houseEndPoint = 5;
        final int treePoint = 7;

        assertThat(hasFruitFallenOnTheHouse(houseStartPoint, houseEndPoint, treePoint, -2), equalTo(true));
        assertThat(hasFruitFallenOnTheHouse(houseStartPoint, houseEndPoint, treePoint, -1), equalTo(false));
    }

    @Test
    public void shouldCountNumberOfFruitsFallenOnHouse() {
        int houseStartPoint = 3;
        int houseEndPoint = 5;
        final int treePoint = 7;
        final int[] fruitsFallDistances = {-2, -1};
        final long expected = 1;

        assertThat(count(houseStartPoint, houseEndPoint, treePoint, fruitsFallDistances), equalTo(expected));
    }

    @Test
    public void testHackerrankInputs() {
        countApplesAndOranges(7, 11, 5, 15, new int[]{-2, 2, 1}, new int[]{5, -6}); //Expected : 1, 1
        countApplesAndOranges(7, 11, 5, 15, new int[]{2, 6, 1, 7}, new int[]{-4, -8, -3, -9}); //Expected: 2, 2
    }

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        System.out.println(count(s, t, a, apples));
        System.out.println(count(s, t, b, oranges));

    }

    private static long count(final int houseStartPoint, final int houseEndPoint, final int treePoint, final int[] fruitsFallDistances) {
        return Arrays.stream(fruitsFallDistances)
                .filter(fd -> hasFruitFallenOnTheHouse(houseStartPoint, houseEndPoint, treePoint, fd))
                .count();
    }

    private static boolean hasFruitFallenOnTheHouse(final int houseStartPoint, final int houseEndPoint, final int treePoint, final int fruitFallDistance) {
        return hasFallenOnTheHouse(houseStartPoint, houseEndPoint, fruitFallPoint(treePoint, fruitFallDistance));
    }

    private static boolean hasFallenOnTheHouse(final int houseStartPoint, final int houseEndPoint, final int fruitFallPoint) {
        return fruitFallPoint >= houseStartPoint && fruitFallPoint <= houseEndPoint;
    }

    private static int fruitFallPoint(final int treePoint, final int fruitFallDistance) {
        return treePoint + fruitFallDistance;
    }
}
