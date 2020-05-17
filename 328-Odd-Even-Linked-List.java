/**
 * Problem 328: Odd Even Linked List
 * Given a singly linked list, group all odd nodes together 
 * followed by the even nodes. Please note here we are talking 
 * about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in
 * O(1) space complexity and O(nodes) time complexity.
 */
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        while (cur.next != null)
            cur = cur.next;
        ListNode mark = cur;
        ListNode fcur = head;
        ListNode ecur = mark;
        while (fcur != mark && fcur.next != null)
        {
            ListNode temp = new ListNode(fcur.next.val);
            ecur.next = temp;
            ecur = ecur.next;
            if (fcur.next == mark)
            {
                fcur.next = fcur.next.next;
                fcur = fcur.next;
                break;
            }
            else
            {
                fcur.next = fcur.next.next;
                fcur = fcur.next;
            }
        }
        return head;
    }
}

/**
 * Notes: Loop through the list and mark the end of the list
 * Unless the cursor reach the mark or there is no next
 * node, we process the node by moving the even node
 * to the end. Once it is deleted, the cursor is automatically
 * moved forward. 
 * The case with odd and even number of nodes will differ
 * as cur reaches the mark. 
 */