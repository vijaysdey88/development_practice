package com.vijay.study.easy.problemsolving;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.stream.IntStream;

import static com.vijay.study.easy.problemsolving.BiggerIsBetter.biggerIsGreater;
import static org.junit.Assert.*;

public class BiggerIsBetterTest {



    @Test
    public void shouldReturnNoAnswerForAllSameAlphabets(){
        verify("aa", "no answer");
        verify("a", "no answer");
    }

    private void verify(String input, String exp) {
        assertThat("Incorrect output for " + input, biggerIsGreater(input), Matchers.equalTo(exp));
    }

    @Test
    public void shouldSwapForTwoDigitWord(){
        verify("ab", "ba");
    }

    @Test
    public void shouldSwapForThreeDigitWordMovingLastCharacterPlaceRight(){
        verify("cab", "cba");
    }


    @Test
    public void shouldSwapLastCharacterWithFirst(){
        verify("abdc", "acbd");
    }

    @Test
    public void shouldReturnNoAnswerWhenAllCharactersAppearInDescendingOrder(){
        verify("cba", "no answer");
    }

    @Test
    public void hkSamples(){
        String[] inputs = {"lmno",
                "dcba",
                "dcbb",
                "abdc",
                "abcd",
                "fedcbabcd"};


        String[] expOutputs = {
                "lmon",
                "no answer",
                "no answer",
                "acbd",
                "abdc",
                "fedcbabdc"
        };

        IntStream.range(0, inputs.length)
                .forEach( i -> verify(inputs[i], expOutputs[i]));

    }

    @Test
    public void hkSamples1(){
        String[] inputs = {
                "dhck",
                "dkhc"
                };


        String[] expOutputs = {
                "dhkc",
                "hcdk"
        };

        IntStream.range(0, inputs.length)
                .forEach( i -> verify(inputs[i], expOutputs[i]));

    }

//    @Test
//    public void shouldSwapForThreeDigitWordMovingLastTwoCharacterPlaceRight(){
//        assertThat(biggerIsGreater("acb"), Matchers.equalTo("cba"));
//    }

}