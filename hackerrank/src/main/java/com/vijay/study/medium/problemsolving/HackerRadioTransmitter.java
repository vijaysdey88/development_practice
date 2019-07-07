package com.vijay.study.medium.problemsolving;
//https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
public class HackerRadioTransmitter {

    static int hackerlandRadioTransmitters(int[] x, int k) {
        int current = 1;
        int antennas = 0;
        while(current < x.length) {
            if((distance(x, current-1, current) < k) && (distance(x, current, current+1) < k)) {
                antennas += 3;
                current += 3;
            }
            else if((distance(x, current-1, current) == k) && (distance(x, current, current+1) == k)) {
                antennas++;
                current += 2;
            }

            else if((distance(x, current-1, current) > k) && (distance(x, current, current+1) == k)) {
                antennas =+ 2;
                current += 2;
            }

            else if((distance(x, current-1, current) == k) && (distance(x, current, current+1) > k)) {
                antennas =+ 2;
                current += 2;
            }
        }



        return antennas;
    }

     private static int distance(int[] x, int first, int second) {
        if(second > x.length)
            return x[first];
       return x[second] - x[first];
    }
}
