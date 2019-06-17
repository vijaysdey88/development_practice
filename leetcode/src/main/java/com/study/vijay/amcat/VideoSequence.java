package com.study.vijay.amcat;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public final class VideoSequence {

    public static VideoSequence INSTANCE = new VideoSequence();

    private VideoSequence() {
    }


    public List<Integer> apply(List<Character> input) {
        List<Integer> result = Lists.newArrayList();
        int index = 0;
        while(index < input.size()) {
            Character startCharacter = input.get(index);
            int endOfSubsequence = input.lastIndexOf(startCharacter);
            if(endOfSubsequence == index) {
                result.add(1);
            } else {
                result.add(endOfSubsequence - index + 1);
            }
            index = endOfSubsequence + 1;
        }
        return result;
    }
}
