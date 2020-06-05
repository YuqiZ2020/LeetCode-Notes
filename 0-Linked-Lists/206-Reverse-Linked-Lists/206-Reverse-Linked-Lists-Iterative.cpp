/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode * curNew = head;
        while (curNew->next != nullptr)
            curNew = curNew->next;
        ListNode * cur = head;
        while (cur != curNew)
        {
            ListNode * temp = new ListNode(cur->val);
            temp->next = curNew->next;
            curNew->next = temp;
            cur = cur->next;
        }
        return curNew;
    }
};

/**
 * Notes: Iterative solution. 
 * Find the end of the linked list. Make a copy of the node each time 
 * and then insert it right after the end marker. Finally return
 * the end marker. 
 * */