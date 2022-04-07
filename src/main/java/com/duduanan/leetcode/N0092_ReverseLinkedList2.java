package com.duduanan.leetcode;

public class N0092_ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left == 1)
        {
            return  reverseN(head, right);
        }

        head.next = reverseBetween(head.next, left -1, right -1);

        return head;
    }

    ListNode successor = null;
    private ListNode reverseN(ListNode node, int n)
    {
        if(n == 1) {
            successor = node.next;
            return node;
        }

        ListNode last = reverseN(node.next, n -1);
        node.next.next = node;
        node.next = successor;
        return last;

    }
}
