package com.vijay.study.easy.problemsolving;

import java.util.Arrays;

public class MarkAndToys {

    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);

        int spent = 0;
        int i = 0;
        for (; i < prices.length; i++) {
            spent += prices[i];
            if(spent > k) {
                break;
            }
        }
        return i;
    }
}
