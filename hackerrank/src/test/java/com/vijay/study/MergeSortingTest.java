package com.vijay.study;

import org.junit.Test;

public class MergeSortingTest {

    @Test
    public void mergeSortInput1(){
        int[] input = {4, 5, 6, 7, 8};

        mergeSort(input);
    }

    private void mergeSort(int[] input) {
        mergeSort(input, 0, input.length - 1);
    }

    private void mergeSort(int[] input, int l, int r) {
        int m = (l + r) / 2;

        mergeSort(input, l, m);
        mergeSort(input, m + 1, r);
        merge(input, l, r);
    }

    private void merge(int[] input, int l, int r) {
        if(l == r)
            return ;
    }


}
