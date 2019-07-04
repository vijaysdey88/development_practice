package com.vijay.study.medium.problemsolving;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static com.vijay.study.medium.problemsolving.Encryption.encryption;
import static org.junit.Assert.*;

public class EncryptionTest {

    @Test
    public void shouldEncryptForSingleWordWithPerfectSquareLength(){
        verify("abcd", "ac bd");
        verify("abcdefghi", "adg beh cfi");
    }

    @Test
    public void shouldEncryptForMultipleWordWithPerfectSquareLength(){
        verify("ab cd ef ghi", "adg beh cfi");
    }

    @Test
    public void shouldSetDimmensionsOfEncryptedWordsForImperfectSquareLength(){
        verify("abc", "ac b");
        verify("haveaniceday", "hae and via ecy");
        verify("feedthedog", "fto ehg ee dd");
        verify("chillout", "clu hlt io");
    }

    private void verify(String input, String exp) {
        Assert.assertThat(encryption(input), Matchers.equalTo(exp));
    }

//    @Test
//    public void shouldFormTheGrid(){
//        final String input = "abcd";
//        final Character[][] grid = {{'a', 'b'}, {'c', 'd'}};
//
//        Assert.assertThat(Encryption.createGrid(input, ), Matchers.equalTo(exp));
//    }

}