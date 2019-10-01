package com.vijay.study.medium.maps;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestCompute {

    public static void main(String[] args) {
        Map<String, Long> freq = Arrays.asList("a", "b", "a", "a")
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        computeDecrementingFreq(freq, "a");
        computeDecrementingFreq(freq, "b");
        computeDecrementingFreq(freq, "b");
        computeDecrementingFreq(freq, "c");
    }

    private static void computeDecrementingFreq(Map<String, Long> freq, String key) {
        System.out.println(freq.compute(key, (k, v) -> {
            System.out.println("Computing for " + key);
            if(null == v || v == 0)
                return null;
            else
                return v - 1;
        }));
        System.out.println(freq.get(key));
    }
}
