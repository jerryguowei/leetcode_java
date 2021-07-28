package com.duduanan.leetcode;

public class N0082_RemoveDuplicateFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode node = new ListNode(Integer.MAX_VALUE, head);
        while(node.next != null && node.next.next != null){
            if(node.next.val == node.next.next.val){
                int duplicate = node.next.val;
                while(node.next != null && node.next.val == duplicate){
                    node.next = node.next.next;
                }
                if(duplicate == head.val) {
                    head = node.next;
                }
            } else {
                node = node.next;
            }

        }
        return head;
    }
}
