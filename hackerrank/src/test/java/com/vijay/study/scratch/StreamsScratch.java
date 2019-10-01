package com.vijay.study.scratch;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamsScratch {

    @Test
    public void testFiltering() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        list.stream()
                .filter(i -> {
                    System.out.println("analysing " + i);
                    return i % 2 ==0;
                }).findFirst()
                .ifPresent(System.out::println);
    }
}
