package com.vijay.study.easy.string;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CamelCaseWordsCountTest {
    
    @Test
    public void shouldReturn0ForEmpty() {
        assertThat(countCamelCase(""), equalTo(0));
    }

    @Test
    public void shouldReturn1ForSingleWord() {
        assertThat(countCamelCase("hi"), equalTo(1));
    }

    @Test
    public void shouldCountTwoWords() {
        assertThat(countCamelCase("hiThere"), equalTo(2));
    }

    @Test
    public void shouldCountMultipleWords() {
        assertThat(countCamelCase("hiThereThisIsVijay"), equalTo(5));
    }

    @Test
    public void shouldCountWithSingleCharWords() {
        assertThat(countCamelCase("hiTTIV"), equalTo(5));
    }

    private int countCamelCase(final String s) {
        if(s.length() == 0)
            return 0;
//        int cnt = 1;
//        for (int i = 0; i < s.length(); i++) {
//            final char c = s.charAt(i);
//            if(c >= 65 && c <= 90) {
//                cnt++;
//            }
//        }
        return s.length() - s.replaceAll("[A-Z]", "").length() + 1;
    }

//    private int countCamelCase(final String input) {
//        int cnt = 0;
//        final String regex = "[A-Z]{1}[A-Za-z0-9]*";
////        final Scanner sc = new Scanner(input).useDelimiter("[A-Z]+");
////
////        while(sc.hasNext()) {
////            cnt++;
////            System.out.println(sc.next());
////        };
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(input);
//
//        while(m.find()) {
//            cnt++;
//            System.out.println(m.group());
//        }
//
//        final String[] split = input.split(regex);
//        return cnt;
//    }
}
