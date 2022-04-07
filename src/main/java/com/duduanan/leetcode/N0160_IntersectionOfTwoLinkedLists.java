package com.duduanan.leetcode;

public class N0160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;

        while(l1 != l2)
        {
            if(l1 == null) l1 = headB;
            else l1 = l1.next;
            if(l2 == null)  l2 = headA;
            else l2 = l2.next;
        }

        return l1;

    }
}
