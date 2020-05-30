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

/**
 * Problem: Add Two Numbers
 * Prompt: You are given two non-empty linked lists representing 
 * two non-negative integers. The digits are stored in reverse order 
 * and each of their nodes contain a single digit. Add the two numbers 
 * and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero. 
 * Date: 05/02/2020
 * Tag: Linked Lists
 * */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode * cur1 = l1;
        ListNode * cur2 = l2;
        ListNode * ans = new ListNode();
        ListNode * curAns = ans;
        int extra = 0;
        while (cur1 || cur2 || extra)
        {
            int val1 = 0;
            int val2 = 0;
            if (cur1)
            {
                val1 = cur1->val;
                cur1 = cur1->next;
            }
            if (cur2)
            {
                val2 = cur2->val;
                cur2 = cur2->next;
            }
            int num = val1 + val2 + extra;
            extra = num / 10;
            curAns->next = new ListNode(num % 10);
            curAns = curAns->next;
        }
        return ans->next;
    }
    
};