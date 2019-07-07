package com.vijay.study.medium.problemsolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAnagram {

    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> freqMap = createFrequencyMap(s);
        return freqMap.values()
                        .stream()
                        .filter(f -> f > 1)
                        .reduce(0, (a,b) -> a+calcluateCombinations(b))
                        .intValue();

    }

    private static Map<String, Integer> createFrequencyMap(String s) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= s.length()-i; j++) {
                String substr = getSortedSubstrnig(s, j, i);
                freqMap.merge(substr, 1, (oldCnt,newCnt) -> oldCnt+newCnt);
            }
        }
        return freqMap;
    }

    private static String getSortedSubstrnig(String s, int startIndex, int charCnt) {
        final char[] chars = s.substring(startIndex, startIndex + charCnt).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static int calcluateCombinations(Integer freq) {
        return (freq*(freq - 1))/2;
    }

}
