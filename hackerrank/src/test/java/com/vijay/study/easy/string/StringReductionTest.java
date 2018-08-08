package com.vijay.study.easy.string;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

//https://www.hackerrank.com/challenges/reduced-string/problem
public class StringReductionTest {

    @Test
    public void shouldReturnEmptyForEmptyInput() {
        assertThat(reduce(""), equalTo("Empty String"));
    }

    @Test
    public void shouldNotCompressForUniqueCharacters() {
        assertThat(reduce("a"), equalTo("a"));
        assertThat(reduce("ab"), equalTo("ab"));
    }

    @Test
    public void shouldCompressTwoConsecutiveInputs() {
        assertThat(reduce("aa"), equalTo("Empty String"));
    }

    @Test
    public void shouldCompressAndRetainUniqueChar() {
        assertThat(reduce("baa"), equalTo("b"));
        assertThat(reduce("bba"), equalTo("a"));
        assertThat(reduce("bbacc"), equalTo("a"));
    }

    @Test
    public void shouldCompressFor3ConsecutiveLetters() {
        assertThat(reduce("baaa"), equalTo("ba"));
        assertThat(reduce("bbbaaa"), equalTo("ba"));
    }

    @Test
    public void shouldReduceAtTwoLevels() {
        assertThat(reduce("baab"), equalTo("Empty String"));
        assertThat(reduce("cbaabc"), equalTo("Empty String"));
    }

    @Test
    public void testHackerInputs() {
        assertThat(reduce("aaabccddd"), equalTo("abd"));
    }

    private static String reduce(final String input) {
        final StringBuilder sb = new StringBuilder(input);

        for (int i = 0; i < sb.length() - 1;) {
            if(sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                if(i - 1 >= 0)
                    i--;
            } else {
                i++;
            }
        }
        return sb.length() == 0 ? "Empty String" : sb.toString();
    }

//    private static String reduce(final String input) {
//        final List<Character> compressed = getCharacters(input);
//        int i = 0;
//        while(i < compressed.size() - 1) {
//            if(compressed.get(i) == compressed.get(i + 1)) {
//                compressed.remove(i);
//                compressed.remove(i);
//                if(i - 1 >= 0)
//                    i--;
//                continue;
//            }
//            i++;
//        }
//        return compressed.size() == 0 ? "Empty String" : convertToString(compressed);
//    }

    private static List<Character> getCharacters(final String input) {
        final List<Character> chars = new ArrayList<>();
        for (int i = 0; i < input.toCharArray().length; i++) {
            chars.add(input.charAt(i));
        }
        return chars;
    }

    private static String convertToString(final List<Character> compressed) {
        final char[] output = new char[compressed.size()];
        for (int i = 0; i < compressed.size(); i++) {
            output[i] = compressed.get(i);
        }
        return new String(output);
    }
}
