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
        if (head == nullptr || head->next == nullptr)
            return head;
        ListNode * t = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr;
        return t;
    }
};

/**
 * Notes: Recursively reverse a linked list. When the node
 * is nullptr or next node is nullptr then just return it. 
 * Other wise define a node that recursively call the function 
 * for the corresponding linked list after this node. 
 * Turn the node pointer around for head. Then return 
 * the reversed version. 
 * */