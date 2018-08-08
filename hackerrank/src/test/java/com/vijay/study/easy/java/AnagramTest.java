package com.vijay.study.easy.java;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AnagramTest {

    @Test
    public void shouldBeAnAnagram() {
        final String a = "abc";

        assertThat(isAnagram(a, "bac"), equalTo(true));
        assertThat(isAnagram(a, "cAB"), equalTo(true));
        assertThat(isAnagram(a, "Abc"), equalTo(true));
    }

    @Test
    public void shouldNotBeAnAnagram() {
        final String a = "abc";
        assertThat(isAnagram(a, "xyz"), equalTo(false));
    }

    static boolean isAnagram(String a, String b) {
        final String a1 = sort(a);
        final String b1 = sort(b);
        return a1.equals(b1);
    }

    private static String sort(final String input) {
        return Arrays.stream(input.split("")).map(String :: toLowerCase).sorted().collect(Collectors.joining(""));
    }
}
