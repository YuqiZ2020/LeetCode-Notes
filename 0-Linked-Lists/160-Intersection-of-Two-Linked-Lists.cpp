/**
 * Problem 160: Intersection of Two Linked Lists
 * Prompt: Write a program to find the node at which the 
 * intersection of two singly linked lists begins.
 * Date: 05/31/2020
 * */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* curA = headA;
        ListNode* curB = headB;
        
         while (curA != curB) 
         {
            if (curA != nullptr)
                curA = curA->next;  
            else
                curA = headB;
            
            if (curB != nullptr)
                curB = curB->next;
            else
                curB = headA; 
        }
        return curA;
        
    }
};

/**
 * Notes: Let the two pointers proceed from each of the head, 
 * if one reaches the end first, then go to the opposite head and 
 * continue. 
 * If they meet then that's the starting point of the intersection. 
 * Otherwise they will both become nullptr at the same time in
 * the end. 
 * */