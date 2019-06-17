package com.study.vijay.leetcode;


public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carryover) {
        if(null == l1 && null == l2 && carryover == 0)
            return null;

        final AdditionResult result = add(l1, l2, carryover);
        ListNode r = result.n;
        r.next = addTwoNumbers(next(l1), next(l2), result.carryover);
        return r;
    }

    private AdditionResult add(ListNode l1, ListNode l2, int carryover) {
        int sum = value(l1) + value(l2) + carryover;
        int val = sum % 10;
        int newCarryover = sum / 10;
        return new AdditionResult(new ListNode(val), newCarryover);
    }

    private ListNode next(final ListNode l) {
        return null != l ? l.next : null;
    }

    private int value(final ListNode l) {
        return null != l ? l.val : 0;
    }

    private static class AdditionResult {
        final ListNode n;
        final int carryover;

        public AdditionResult(ListNode n, int carryover) {
            this.n = n;
            this.carryover = carryover;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
