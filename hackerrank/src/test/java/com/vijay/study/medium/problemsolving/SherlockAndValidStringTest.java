package com.vijay.study.medium.problemsolving;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class SherlockAndValidStringTest {

    @Test
    public void shouldReturnYesWhenFrequenciesOfAllCharactersIsSame(){
        verify("aabbcc", "YES");
    }

    @Test
    public void shouldReturnNoWhenFrequenciesNotEqualAndCannotBeRectified(){
        verify("aabbbbcc", "NO");
    }

    @Test
    public void shouldReturnYesWhenFrequenciesCanBeRectifiedByReducingAChar(){
        verify("aabbbcc", "YES");
    }

    @Test
    public void shouldReturnNoIfMoreThanOneCharFreqNeedsRectification(){
        verify("aabbbccc", "NO");
    }

    @Test
    public void shouldReturnYesWhenFrequenciesDeletingOneCharCompletely(){
        verify("aabbc", "YES");
    }

    @Test
    public void shouldReturnNoWhenFrequenciesDeletingMoreThanOneCharCompletely(){
        verify("aabbcd", "NO");
    }

    @Test
    public void shouldReturnNoWhenHugeGapInFirstAndSubsequencttFrequencies(){
        verify("aaabc", "NO");
        verify("abbbc", "NO");
        verify("bbbbcc", "NO");
    }

    @Test
    public void shouldReturnYesWhenCommonFrequenceIsOne(){
        verify("bbc", "YES");
        verify("caabc", "YES");
    }

    @Test
    public void shouldReturnYesForSingleCharString(){
        verify("b", "YES");
    }

    @Test
    public void testHK1(){
        verify("aabbccddeefghi", "NO");
    }

    @Test
    public void testHK2(){
        verify("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd",
                "YES");
    }

    private void verify(String i, String yes) {
        assertThat("input:"+i, SherlockAndValidString.isValid(i), Matchers.equalTo(yes));
    }
}