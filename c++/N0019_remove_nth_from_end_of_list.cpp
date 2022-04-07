#include "list_node.h"

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
        ListNode* node = head;
        while(n-- > 0)  node = node -> next;
        
        ListNode* dummy = new ListNode();
        dummy -> next = head;
        head = dummy;
        
        while(node)
        {
            node = node -> next;
            dummy = dummy -> next;
        }
        
        dummy -> next = dummy -> next -> next;
        return head -> next;
    }
};