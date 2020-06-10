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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        head.next = removeElements(head.next, val);
        if (head.val == val)
            return head.next;
        return head;
    }
}

/**
 * Notes: Process the elements after the head using a recursive call; 
 * If this node has the current value than just return the next node
 * otherwise still return the current node. 
 */