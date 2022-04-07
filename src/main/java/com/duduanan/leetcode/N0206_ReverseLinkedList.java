package com.duduanan.leetcode;

public class N0206_ReverseLinkedList {

    public ListNode reverseList(ListNode head)
    {
        return recurse(head);
    }

    public ListNode recurse(ListNode node)
    {
      if(node == null || node.next == null) return node;
      ListNode last = recurse(node.next);

      node.next.next = node;
      node.next = null;
      return last;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null) return null;
        ListNode node = head;
        ListNode next = head.next;
        head.next = null;
        while(next != null)
        {
            ListNode tempNext = next.next;
            next.next = node;
            node = next;
            next = tempNext;
        }

        return node;
    }
}
