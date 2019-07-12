package com.vijay.study.easy.problemsolving;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

//https://www.hackerrank.com/challenges/jesse-and-cookies/problem
public class JesseAndCookies {


    static int cookies(int k, int[] A) {
        final Queue<Integer> pq = new PriorityQueue<>();
        IntStream.of(A)
                .forEach(pq :: add);

        int cnt = 0;
        while (!pq.isEmpty()) {
            final Integer smaller = pq.remove();
            if(smaller >= k)
                return cnt;

            if(!pq.isEmpty()) {
                final Integer bigger = pq.remove();
                cnt++;
                final int s = calculateSweetness(smaller, bigger);
                pq.add(s);
            }
        }

        return -1;
    }

    private static int calculateSweetness(Integer s1, Integer s2) {
        return s1*1 + s2*2;
    }
}
