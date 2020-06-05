/**
 * Problem 234: Palindrome Linked List
 * Prompt: Given a singly linked list, determine if 
 * it is a palindrome.
 * Date: 06/04/2020
 * */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if (head == nullptr)
            return true;
        ListNode * cur2 = reverseList(head);
        ListNode * cur1 = head;
        while (cur2 != nullptr)
        {
            if (cur1->val != cur2->val)
                return false;
            cur1 = cur1->next;
            cur2 = cur2->next;
        }
        return true;
    }
    
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
 * Notes: Reverse the entire linked list and save it
 * using another linked list. Then compare the two linked
 * lists. If they are the same, then the linked list
 * is a palindrome. 
 * */