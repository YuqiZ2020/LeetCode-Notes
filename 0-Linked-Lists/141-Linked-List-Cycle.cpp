/**
 * Problem 141: Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
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
    bool hasCycle(ListNode *head) {
        ListNode *fast = head, *slow = head;
        while(slow && fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
            if(slow == fast) 
                return true;
        }
        return false;
    }
};

/**
 * Notes: Use two pointer, one is faster that skip
 * a node each time. The other is slower with original step
 * by step speed. 
 * Then if the two pointers meet each other, then this graph
 * has a cycle. 
 * */