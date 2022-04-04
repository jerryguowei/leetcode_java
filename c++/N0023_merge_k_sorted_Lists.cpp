#include  <queue>
#include <vector>
#include "list_node.h"
using namespace std;

class Solution {
    public:
        ListNode* mergeKLists(vector<ListNode*> &lists)
        {
             auto f = [](ListNode* l1, ListNode* l2) -> bool { return l1 -> val > l2 -> val;};
             priority_queue<ListNode*, vector<ListNode*>, decltype(f)> pq(f);  

             ListNode* dumpy = new ListNode;
             ListNode* curr = dumpy;
             
             for(auto l : lists)
                if(l) pq.push(l);
            while(pq.size() > 0)
            {
                ListNode* temp = pq.top();
                pq.pop();
                curr -> next = temp;
                curr  = curr -> next;
                temp = temp -> next;
                if(temp) pq.push(temp);
            }

            curr = dumpy -> next;
            delete dumpy;
            return curr;
        }
};
