package com.duduanan.leetcode;

import java.util.Random;

/**
 * 382. Linked List Random Node
 * Medium
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 *
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 *
 */
public class N0382_LinkedListRandomNode {

    private ListNode head;
    public N0382_LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode p = head;
        Random random = new Random();
        int i = 0;
        int res = 0;
        while(p != null) {
            if(random.nextInt(++i) == 0){
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
