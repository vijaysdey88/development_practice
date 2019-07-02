package com.vijay.study.easy.problemsolving;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class HurdleRace {

    static int hurdleRace(int k, int[] height) {
        final Supplier<IntStream> intStreamSupplier = () -> Arrays.stream(height)
                .boxed()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .mapToInt(h -> h - k)
                .filter(h -> h > 0);

        return intStreamSupplier.get()
                                .findFirst().orElse(0);
    }


    public static void main(String[] args) {
        final int[] input = Arrays.stream("1 6 3 5 2".split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        System.out.println(hurdleRace(4, input));

    }
}
