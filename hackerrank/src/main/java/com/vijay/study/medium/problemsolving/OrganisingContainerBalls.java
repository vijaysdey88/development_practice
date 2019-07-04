package com.vijay.study.medium.problemsolving;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrganisingContainerBalls {

    static String organizingContainers(int[][] container) {
//        final int[] containerBallsCounts = IntStream.range(0, container.length)
//                .map(i -> Arrays.stream(container[i]).sum())
//                .sorted()
//                .toArray();
//
//        final int[] ballTypeCounts = IntStream.range(0, container.length)
//                .map(i -> {
//                    int sum = 0;
//                    for (int j = 0; j < container[0].length; j++) {
//                        sum += container[j][i];
//                    }
//                    return sum;
//                })
//                .sorted()
//                .toArray();

        final int[] containerBallsCounts = new int[container.length];
        final int[] ballTypeCounts = new int[container.length];
        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container.length; j++) {
                containerBallsCounts[i] += container[i][j];
                ballTypeCounts[j] += container[i][j];
            }
        }
        Arrays.sort(containerBallsCounts);
        Arrays.sort(ballTypeCounts);


        return Arrays.equals(containerBallsCounts, ballTypeCounts) ? "Possible" : "Impossible";
    }
}
