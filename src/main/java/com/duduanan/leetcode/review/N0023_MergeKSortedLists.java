package com.duduanan.leetcode.review;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * Hard
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class N0023_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node == null) continue;
            pq.offer(node);
        }
        ListNode root = null;
        ListNode temp = null;
        while (!pq.isEmpty()) {
            ListNode tempNode = pq.poll();
            if (temp == null) {
                root = tempNode;
                temp = tempNode;
            } else {
                temp.next = tempNode;
                temp = temp.next;
            }
            if (tempNode.next != null) {
                pq.offer(tempNode.next);
            }
        }
        return root;
    }
}
