package com.study.vijay.amcat;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

;

public class VideoSequenceTest {

    @Test()
    public void shouldReturn1ForUniqueElementsInInputForThreeElements(){
        verify(execute('a', 'b', 'c'), 1, 1, 1);
    }

    @Test()
    public void shouldPartitionAtSecondIndexForThreeElementsForConsecutiveRepetitionForThreeElements(){
        verify(execute('a', 'a', 'b'), 2, 1);
        verify(execute('a', 'b', 'b'), 1, 2);
    }

    @Test()
    public void shouldPartitionTillEndForConsecutiveRepetitionForThreeElements(){
        verify(execute('a', 'a', 'a'), 3);
    }

    @Test()
    public void shouldPartitionTillEndForNonConsecutiveRepetitionForThreeElements(){
        verify(execute('a', 'b', 'a'), 3);
    }

    @Test()
    public void shouldReturn1ForUniqueElementsInInputFor4Elements(){
        verify(execute('a', 'b', 'c', 'd'), 1, 1, 1, 1);
    }

    @Test()
    public void shouldPartitionInto2For4Elements(){
        verify(execute('a', 'b', 'a', 'd'), 3, 1);
        verify(execute('a', 'b', 'c', 'b'), 1, 3);
    }

    @Test()
    public void shouldPartitionInto3For4Elements(){
        verify(execute('a', 'b', 'b', 'd'), 1, 2, 1);
        verify(execute('a', 'a', 'c', 'b'), 2, 1, 1);
    }

    @Test()
    public void testForLongerStream(){
        verify(execute('a', 'b', 'c', 'a', 'e', 'f', 'e', 'r', 'l', 'm', 'r', 'z'), 4, 3, 4, 1);
    }

    private void verify(List<Integer> result, Integer... expected) {
        assertEquals(Lists.newArrayList(expected), result);
    }

    private List<Integer> execute(Character... inputs) {
        final List<Character> input = Lists.newArrayList(inputs);
        return VideoSequence.INSTANCE.apply(input);
    }


}