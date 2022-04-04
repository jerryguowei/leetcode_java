package com.duduanan.leetcode;

public class N0023_MergeKSortedLists {


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int low, int hi)
    {
        if(low == hi) return lists[low];
        int mid = low + hi >> 1;
        ListNode l1 = merge(lists, low, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return combine(l1, l2);
    }

    public ListNode combine(ListNode l1, ListNode l2)
    {
        if(l1 == l2) return l1;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val > l2.val)
            {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if(l1 != null) cur.next = l1;
        else if(l2 != null) cur.next = l2;

        return dummy.next;
    }
}
