/**
 * Problem 142: Linked List Cycle II
 * Prompt: Given a linked list, return the node where the 
 * cycle begins. If there is no cycle, return null.
 * Date: 05/31/2020
 * */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode *fast = head, *slow = head;
        bool flag = false;
        while(slow && fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
            if(slow == fast) 
            {
                flag = true;
                break;
            }
        }
        
        if (!flag)
            return nullptr;
        slow = head;
        while (slow != fast)
        {
            slow = slow->next;
            fast = fast->next;
        }
        return fast;
    }
};

/**
 * Notes: First use two pointers to determine
 * if the linked list has a cycle. 
 * If yes, let the slow pointer go back to the original head
 * and let the two pointer proceed together, when they meet, 
 * it is where the start of the cycyle is. 
 * */