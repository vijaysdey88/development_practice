package com.vijay.study.sorting;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

public class InsertionSort {

    public static void sort(int[] input) {
        Set.of("");

        IntStream.range(0, input.length).forEach(i -> {
            int j = i;
            while (j > 0 && input[j-1] > input[j]) {
                exchangeNeighbours(input, j);
                j--;
            }
        });
    }

    private static void exchangeNeighbours(int[] input, int j) {
        int tmp = input[j - 1];
        input[j-1] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {4, 6, 0, 2, 0, 1};

        sort(input);

        System.out.println(Arrays.toString(input));
    }
}


