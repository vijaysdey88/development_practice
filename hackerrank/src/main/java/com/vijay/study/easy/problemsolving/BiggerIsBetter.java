package com.vijay.study.easy.problemsolving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.hackerrank.com/challenges/bigger-is-greater/problem
public class BiggerIsBetter {
    public static String biggerIsGreater(String input) {
//        final char[] chars = input.toCharArray();
//        int i = input.length() - 2;
//        int maxIdx = input.length() - 1;
//        while(i >= 0) {
//            if(chars[maxIdx] > chars[i]) {
//                char tmp = chars[i];
//                chars[i] = chars[maxIdx];
//                chars[maxIdx] = tmp;
//
//                StringBuilder sb = new StringBuilder();
//                for(int j = 0 ; j < i; j++) {
//                    sb.append(chars[j]);
//                }
//
//                sb.append(chars[i]);
//
//                final List<Character> endingChars = new ArrayList<>();
//                for(int j = i + 1; j < input.length(); j++) {
//                    endingChars.add(chars[j]);
//                }
//
//                Collections.sort(endingChars);
//                for (Character c : endingChars)
//                    sb.append(c);
//                return sb.toString();
//            } else {
//                maxIdx = i;
//            }
//            i--;
//        }

        int j = input.length() - 1;
        while(j > 0) {
            int i = j;
            char last = input.charAt(i);
            while(i >= 0) {
                if(last > input.charAt(i)) {
                    StringBuilder sb = new StringBuilder();
                    for(int k = 0; k < i; k++) {
                        sb.append(input.charAt(k));
                    }

                    sb.append(input.charAt(j));

                    final List<Character> endingChars = new ArrayList<>();
                    for(int k = i; k < input.length(); k++) {
                        if(k != j)
                            endingChars.add(input.charAt(k));
                    }
                    Collections.sort(endingChars);
                    for (Character c : endingChars)
                        sb.append(c);
                    return sb.toString();
                }
                i--;
            }
            j--;
        }
        return "no answer";

    }
}
