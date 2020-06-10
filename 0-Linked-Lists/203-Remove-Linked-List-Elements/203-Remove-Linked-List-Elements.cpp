/**
 * Problem 203: Remove Linked List Elements
 * Prompt: Remove all elements from a linked list of 
 * integers that have value val.
 * Date: 06/02/2020
 * */

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
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* hcur = head;
        while (hcur != nullptr && hcur->val == val)
            hcur = hcur->next;
        ListNode* cur = hcur;
        while (cur != nullptr)
        {
            while (cur->next != nullptr && cur->next->val == val)
                cur->next = cur->next->next;
            cur = cur->next;
        }
        return hcur;
    }
};

/**
 * Notes: Need to consider seperately for deleting starting
 * from the head node. 
 * Otherwise consider the value of the next node (need to use
 * while loop because there could be consecutive occurances)
 * and perform deletion if necessary. Then move cursor forward. 
 * */