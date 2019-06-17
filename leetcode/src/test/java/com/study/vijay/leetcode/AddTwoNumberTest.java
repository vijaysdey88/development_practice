package com.study.vijay.leetcode;

import com.study.vijay.leetcode.AddTwoNumber.ListNode;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class AddTwoNumberTest {

    final AddTwoNumber solution = new AddTwoNumber();

    @Test()
    public void shouldAddSingleDigitsNumbers(){
        final ListNode n1 = new ListNode(4);
        final ListNode n2 = new ListNode(5);

        verifySingleDigit(n1, n2, 9);
    }

    @Test @Ignore
    public void shouldAddNulls(){
        verifySingleDigit(null, null, 0);
    }


    @Test()
    public void shouldAddSingleNumberWhenOtherNumberIsMissing(){
        final ListNode n = new ListNode(4);
        verifySingleDigit(n, null, 4);
        verifySingleDigit(null, n, 4);
    }

    @Test()
    public void shouldAddTwoSingleDigitsWithOverflow(){
        ListNode actual = solution.addTwoNumbers(new ListNode(4), new ListNode(6));
        assertThat(actual.val, equalTo(0));
        assertThat(actual.next.val, equalTo(1));
        assertThat(actual.next.next, nullValue());

        actual = solution.addTwoNumbers(new ListNode(9), new ListNode(9));
        assertThat(actual.val, equalTo(8));
        assertThat(actual.next.val, equalTo(1));
        assertThat(actual.next.next, nullValue());
    }

    @Test()
    public void shouldAddTwoDigitNumbers(){
        final ListNode n1 = constructNode(1, new ListNode(2)); //21
        final ListNode n2 = constructNode(3, new ListNode(4)); //43

        //21 + 43 = 64 => 4 -> 6
        final ListNode actual = solution.addTwoNumbers(n1, n2);

        assertThat(actual.val, equalTo(4));
        assertThat(actual.next.val, equalTo(6));
        assertThat(actual.next.next, nullValue());
    }

    @Test()
    public void shouldAddSingleDigitNumberToTwoDigitsNumber(){
        final ListNode n1 = constructNode(1, new ListNode(2)); //21
        final ListNode n2 = new ListNode(5); //5

        //21 + 5 = 26 => 6 -> 2
        ListNode actual = solution.addTwoNumbers(n1, n2);
        assertThat(actual.val, equalTo(6));
        assertThat(actual.next.val, equalTo(2));
        assertThat(actual.next.next, nullValue());

        //Switching operands
        actual = solution.addTwoNumbers(n2, n1);
        assertThat(actual.val, equalTo(6));
        assertThat(actual.next.val, equalTo(2));
        assertThat(actual.next.next, nullValue());
    }

    @Test()
    public void shouldAddThreeDigitNumbers(){
        final ListNode n1 = constructNode(5, constructNode(4, new ListNode(3))); //345
        final ListNode n2 = constructNode(2, constructNode(1, new ListNode(5))); //512

        //345 + 512 = 857
        ListNode actual = solution.addTwoNumbers(n1, n2);
        assertThat(actual.val, equalTo(7));
        assertThat(actual.next.val, equalTo(5));
        assertThat(actual.next.next.val, equalTo(8));
        assertThat(actual.next.next.next, nullValue());
    }

    @Test()
    public void shouldAddTwoDigitsWithCarryover(){
        final ListNode n1 = constructNode(9, new ListNode(9)); //99
        final ListNode n2 = constructNode(9, new ListNode(9)); //99

        //99 + 99 = 198 => 8 -> 9 -> 1
        ListNode actual = solution.addTwoNumbers(n1, n2);
        assertThat(actual.val, equalTo(8));
        assertThat(actual.next.val, equalTo(9));
        assertThat(actual.next.next.val, equalTo(1));
        assertThat(actual.next.next.next, nullValue());
    }

    //342 + 465 = 807
    @Test()
    public void shouldAddThreeDigitNumbersSample(){
        final ListNode n1 = constructNode(2, constructNode(4, new ListNode(3)));
        final ListNode n2 = constructNode(5, constructNode(6, new ListNode(4)));

        //345 + 512 = 857
        ListNode actual = solution.addTwoNumbers(n1, n2);
        assertThat(actual.val, equalTo(7));
        assertThat(actual.next.val, equalTo(0));
        assertThat(actual.next.next.val, equalTo(8));
        assertThat(actual.next.next.next, nullValue());
    }


    private ListNode constructNode(int val, ListNode next) {
        final ListNode n = new ListNode(val);
        n.next = next;
        return n;
    }

    private void verifySingleDigit(ListNode n1, ListNode n2, int expected) {
        final ListNode actual = solution.addTwoNumbers(n1, n2);
        assertThat(actual.val, equalTo(expected));
        assertThat(actual.next, nullValue());
    }
}