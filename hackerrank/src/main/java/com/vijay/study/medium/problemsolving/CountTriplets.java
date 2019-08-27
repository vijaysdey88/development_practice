package com.vijay.study.medium.problemsolving;

import java.util.*;
import java.util.stream.Collectors;

//https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        return triplets(arr, r).size();

    }


    static List<List<Long>> triplets(List<Long> arr, long r) {
        final Map<Long, List<List<Long>>> triplets = new LinkedHashMap<>();

        arr.stream()
                .forEach(i -> {
                    // Initialise triplets map for i
                    triplets.merge(i, initTriplets(i), (old, cn) -> {
                        old.add(cn.get(0));
                        return old;
                    });

                    long ii = i / r;
                    triplets.computeIfPresent(ii, (key, old) -> {
                        final List<List<Long>> newBranches = new ArrayList<>();
                        old.forEach(t -> {
                            if(t.size() == 1)
                                t.add(i);
                            else if(t.size() == 2) {
                                final ArrayList<Long> next = create(ii);
                                next.add(i);
                                newBranches.add(next);
                            }

                        });
                        old.addAll(newBranches);
                        return old;
                    });

                    long iii = ii / r;
                    triplets.computeIfPresent(iii, (key, old) -> {
                        final List<List<Long>> newBranches = new ArrayList<>();
                        old.forEach(t -> {
                            if(t.size() == 2)
                                t.add(i);
                            else if(t.size() == 3) {
                                final ArrayList<Long> next = create(iii);
                                next.add(ii);
                                next.add(i);
                                newBranches.add(next);
                            }

                        });
                        old.addAll(newBranches);
                        return old;
                    });
                });

        return triplets.values().stream()
                .flatMap(List::stream)
                .filter(l -> l.size() == 3)
                .collect(Collectors.toList());
    }

    private static List<List<Long>> initTriplets(Long i) {
        List<List<Long>> triplets = new ArrayList<>();
        final ArrayList<Long> longs = create(i);
        triplets.add(longs);
        return triplets;
    }

    private static ArrayList<Long> create(Long i) {
        final ArrayList<Long> longs = new ArrayList<>();
        longs.add(i);
        return longs;
    }
}
