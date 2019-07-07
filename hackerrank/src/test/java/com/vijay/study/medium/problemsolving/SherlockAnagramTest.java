package com.vijay.study.medium.problemsolving;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class SherlockAnagramTest {

    @Test
    public void shouldComputeAnagramForRepeatedCharacters(){
        verify("aa", 1);
        verify("aaaa", 10);
    }

    @Test
    public void shouldComputeAnagramFor3Characters(){
        verify("abba", 4);
        verify("cdcd", 5);
        verify("ifailuhkqq", 3);
    }

    private void verify(String input, int expected) {
        assertThat("Incorrect result for :" + input, SherlockAnagram.sherlockAndAnagrams(input), Matchers.equalTo(expected));
    }

}