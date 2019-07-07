package com.vijay.study.medium.problemsolving;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HackerRadioTransmitterTest {

    @Test
    public void shouldUseSingleAntennaWhenNoneighboursAreInRange(){
        verify(new int[]{1, 3, 5, 7}, 1, 1);
    }

    @Test
    public void shouldCoverTwoAdjascentHousesWithMinAntennasForHousesEquallySpaced(){
        verify(new int[]{1, 2, 3}, 1, 1);
        verify(new int[]{1, 2, 3, 4, 5}, 1, 2);
    }


    @Test
    public void shouldCoverWithMinAntennasForHoueseNotSpacedEqually(){
      //  verify(new int[]{1, 3, 4}, 1, 2);
        verify(new int[]{1, 2, 4}, 1, 2);
    }


    private void verify(int[] houses, int k, int i) {
        Assert.assertThat(HackerRadioTransmitter.hackerlandRadioTransmitters(houses, k), Matchers.equalTo(i));
    }
}