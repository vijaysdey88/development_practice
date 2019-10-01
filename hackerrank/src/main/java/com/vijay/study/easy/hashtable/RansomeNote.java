package com.vijay.study.easy.hashtable;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class RansomeNote {

    static void checkMagazine(String[] magazine, String[] note) {
        final Map<String, Long> magazineCounts = Arrays.stream(magazine)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Optional<String> missing = Arrays.stream(note)
                .filter(word -> decrementWordCount(magazineCounts, word) == null)
                .findFirst();

        String result = missing.isPresent() ? "No" : "Yes";
        System.out.println(result);
    }


    private static Long decrementWordCount(Map<String, Long> magazineCounts, String word) {
//        System.out.println("Checking for word " + word);
        return magazineCounts.compute(word, (k, v) -> {
            if(null == v || v == 0)
                return null;
            else
                return v - 1;
        });
    }

    static void checkMagazine(String magazine, String note) {
        checkMagazine(magazine.split(" "), note.split(" "));
    }

    public static void main(String[] args) {
        checkMagazine("give me one grand today night", "give one grand today");
        checkMagazine("two times three is not four", "two times two is four");
        checkMagazine("ive got a lovely bunch of coconuts", "ive got some coconuts");
    }
}
