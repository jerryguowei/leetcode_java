package com.duduanan.leetcode;


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode top = null;
        ListNode curr = null;
        while(l1 != null && l2 != null){
            ListNode node = null;
            if(l1.val <= l2.val){
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }

            if(curr != null) {
                curr.next=node;
            }
            curr  = node;
            if(top == null) top = curr;
        }
        if(l1 != null) {
            if(curr != null) curr.next = l1;
            else top = l1;

        }
        if(l2 != null) {
            if(curr != null) curr.next = l2;
            else top = l2;
        }

        return top;
    }
}
/**
 * 21. Merge Two Sorted Lists
 * Easy
 *
 * 7042
 *
 * 790
 *
 * Add to List
 *
 * Share
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 *
 * */