package com.study.vijay.leetcode;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringTest {

    private final LongestSubstring solution = new LongestSubstring();

    @Test
    public void shouldBlankInputSizeShouldBe0(){
        verify("", 0);
    }

    @Test
    public void shouldConsiderSpaceAsValidChar(){
        verify(" ", 1);
        verify("  ", 1);
        verify("  abcd", 5);
    }

    @Test
    public void shouldReturnLongestSubstringAsLengthForAllUniqueCharacters(){
        verify("abcd", 4);
    }

    @Test
    public void shouldReturn1ForAllUniqueCharacters(){
        verify("aaaa", 1);
        verify("bbbb", 1);
    }

    @Test
    public void shouldReturnLenghtOfLargestSubstringAtTheBeginning(){
        verify("abcdbc", 4);
    }

    @Test
    public void shouldReturnLenghtOfLargestSubstringFromInBetweenToEnd(){
        verify("abacd", 4); //bacd
        verify("abcdaa", 4);
    }

    @Test
    public void shouldReturnLenghtOfLargestSubstringFromInBetween(){
        verify("abcdacd", 4); //bcda

    }


    @Test
    public void lc1(){
        verify("abcabcbb", 3);
    }

    @Test
    public void lc2(){
        verify("bbbbb", 1);
    }

    @Test
    public void lc3(){
        verify("pwwkew", 3);
    }
    private void verify(String input, int exp) {
        Assert.assertThat(solution.lengthOfLongestSubstring(input), Matchers.equalTo(exp));
    }
}