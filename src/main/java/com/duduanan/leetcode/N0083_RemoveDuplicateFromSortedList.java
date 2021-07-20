package com.duduanan.leetcode;

/**
 * 83. Remove Duplicates from Sorted List
 * Easy
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 */
public class N0083_RemoveDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = head.next;
        ListNode last = head;
        while(p != null) {
            if(p.val != last.val){
                last.next = p;
                last = p;
            }
            p = p.next;
        }
        last.next = null;
        return head;
    }
}
