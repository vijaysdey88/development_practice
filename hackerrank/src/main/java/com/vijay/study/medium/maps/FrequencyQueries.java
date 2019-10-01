package com.vijay.study.medium.maps;

//https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {
//    static List<Integer> freqQuery(List<List<Integer>> queries) {
//        final int[] frequencies = new int[(int)Math.pow(10, 9)];
//        final List<Integer> result = new ArrayList<>();
//
//        queries.forEach(query -> {
//            final Integer operation = query.get(0);
//            final Integer data = query.get(1);
//
//            if(operation == 1) {
//                frequencies[data]++;
//            } else if(operation == 2) {
//                if(frequencies[data] > 0) {
//                    frequencies[data]--;
//                }
//            } else {
//                Optional<Integer> match = frequencies.values().stream()
//                        .filter(freq -> freq.equals(data))
//                        .findFirst();
//                if(match.isPresent())
//                    result.add(1);
//                else
//                    result.add(0);
//            }
//        });
//        return result;
//    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        final Map<Integer, Integer> frequencies = new TreeMap<>();
        final List<Integer> result = new ArrayList<>();

        queries.forEach(query -> {
            final Integer operation = query.get(0);
            final Integer data = query.get(1);

            if(operation == 1) {
                frequencies.merge(data, 1, (oldFreq, newFreq) -> oldFreq+newFreq);
            } else if(operation == 2) {
                frequencies.computeIfPresent(data, (key, oldValue) -> {
                    final Integer reducedFreq = oldValue - 1;
                    return reducedFreq > 0 ? reducedFreq : null;
                });
            } else {
                Optional<Integer> match = frequencies.values().stream()
                        .filter(freq -> {
                            System.out.println("filtering ");
                            return freq.equals(data);
                        })
                        .findFirst();
                if(frequencies.containsValue(data))
                    result.add(1);
                else
                    result.add(0);
            }
        });
        return result;
    }


    public static void main(String[] args) throws IOException {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println((int)Math.pow(10, 9));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        System.out.println(ans);
        bufferedReader.close();
    }
}
