package com.study.vijay.leetcode;

import java.util.*;


public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> valToIndex = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            valToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            final int complement = target - nums[i];
            final Integer matchIdx = valToIndex.get(complement);
            if(matchIdx != null && matchIdx != i)
                return new int[]{ i, matchIdx};
        }

        return new int[]{0, 0};
    }
}
