package com.vijay.study.easy.implementation;

import java.util.stream.IntStream;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class DesignerPDFViewerTest {

    static int designerPdfViewer(int[] h, String word) {
        return area(h, word.toCharArray());
    }

    private static int area(final int[] heights, final char[] chars) {
        return getMaxHeight(heights, chars) * chars.length;
    }

    private static int getMaxHeight(final int[] h, final char[] chars) {
        return IntStream.range(0, chars.length)
                    .map(i -> computeHeightIndex(chars[i]))
                    .map(heightIndex -> h[heightIndex])
                    .max().getAsInt();
    }

    private static int computeHeightIndex(final char c) {
        //System.out.println("c : " + c + " ascii value: " + (0 + c));
        final int i = c - 97;
        //System.out.println("i : " + i);
        return i;
    }

    final int[] heights = new int[] {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5} ;

    @Test
    public void shouldGiveAreaForASingelCharacterWord() {
        assertThat(designerPdfViewer(heights, "a"), equalTo(1));;
        assertThat(designerPdfViewer(heights, "b"), equalTo(3));;
        assertThat(designerPdfViewer(heights, "f"), equalTo(4));;
        assertThat(designerPdfViewer(heights, "z"), equalTo(5));;
    }

    @Test
    public void shouldGiveAreaBasedONTallestLetter() {
        assertThat(designerPdfViewer(heights, "ab"), equalTo( 2 * 3));;
    }
}
