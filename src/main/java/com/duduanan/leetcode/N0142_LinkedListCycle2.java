package com.duduanan.leetcode;

public class N0142_LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

        return null;

    }
}
/**
 *  f = 2s;
 *  f = s + nb;
 *  => s = nb;
 *  entry point = a + nb;
 *
 *
 *
 */
