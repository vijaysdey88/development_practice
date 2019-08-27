package com.vijay.study.easy.problemsolving;

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
        while (pq.size() > 1 && pq.peek() < k) {
            final Integer smaller = pq.poll();
            final Integer bigger = pq.poll();
            cnt++;
            final int s = calculateSweetness(smaller, bigger);
            pq.add(s);
        }

        return pq.peek() >= k ? cnt : -1 ;
    }

    private static int calculateSweetness(Integer s1, Integer s2) {
        return s1*1 + s2*2;
    }
}
