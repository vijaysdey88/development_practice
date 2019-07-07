package com.vijay.study.medium.problemsolving;

import java.util.*;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class SherlockAndValidString {

    static String isValid(String s) {
        if(s.length() <= 1)
            return "YES";
        Map<Character, Integer> freqMap = toFrequencyMap(s);
        final List<Integer> frequencies = sortedFrequenciesInAscendingOrder(freqMap);

        Integer referenceFreq = Math.min(frequencies.get(0), frequencies.get(1));
        boolean rectifiedOnce = false;
        if(frequencies.get(0) == 1 && frequencies.get(1) > 1) {
            rectifiedOnce = true;
            referenceFreq = frequencies.get(1);
        }

        for (int i = 1; i < frequencies.size(); i++) {
            int freq = frequencies.get(i);
            final int diff = freq - referenceFreq;
            if(diff > 1 || (diff == 1 && rectifiedOnce))
                return "NO";

            if(diff == 1) {
                rectifiedOnce = true;
            }
        }

        return "YES";
    }

    private static List<Integer> sortedFrequenciesInAscendingOrder(Map<Character, Integer> freqMap) {
        return freqMap.values().stream().sorted().collect(Collectors.toList());
    }

    private static Map<Character, Integer> toFrequencyMap(String s) {
        final char[] chars = s.toCharArray();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            final char c = chars[i];
            freqMap.merge(Character.valueOf(c), 1, (oldFreq, newFreq) -> oldFreq+newFreq);
        }
        return freqMap;
    }

}
