package com.vijay.study.easy.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.hackerrank.com/challenges/bigger-is-greater/problem
public class BiggerIsBetter {
    public static String biggerIsGreater(String input) {
        int i = input.length() - 1;
        char last = input.charAt(input.length() - 1);
        while(i > 0) {
            if(last > input.charAt(i - 1)) {

                final List<Character> endingChars = new ArrayList<>();
                for(int j = i - 1; j < input.length() - 1; j++) {
                    endingChars.add(input.charAt(j));
                }
                Collections.sort(endingChars, (c1, c2) -> c1 - c2);
                StringBuilder sb = new StringBuilder();
                sb.append(last);
                for (Character c : endingChars)
                    sb.append(c);
             return input.substring(0, i - 1)   + sb.toString();
            }
            i--;
        }
        return "no answer";

    }
}
