package com.study.vijay.datastructure.bst;


import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class BSTBasicOperationsTest {

    private BST<Integer, Integer> bst;

    @Before
    public void setup() {
        bst = new BST<>();
    }

    @Test
    public void testAdditionAndRetrievalToBST() {
        insertAndGet(new int[]{2, 1, 3});
    }

    @Test
    public void testRandomAdditionAndRetrievalToBST() {
        final int[] random = IntStream.range(0, 100)
                .map(i -> RandomUtils.nextInt())
                .toArray();

        insertAndGet(random);
    }



    private void insertAndGet(int[] inputs) {
        IntStream.of(inputs)
                .forEach(this :: insert);
        IntStream.of(inputs)
                .forEach(this :: assertRetrieval);
    }

    private void insert(Integer i) {
        bst.put(i, i);
    }

    private void assertRetrieval(Integer i) {
        Assert.assertEquals("Can't find value for key : " + i, i, bst.get(i));
    }
}
