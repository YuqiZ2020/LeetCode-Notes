/**
 * Problem 19: Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur1 = head;
        ListNode cur2 = head;
        int counter = 1;
        while (counter++ <= n)
            cur1 = cur1.next;
        if (cur1 == null)
        {
            head = head.next;
            return head;
        }   
        while (cur1.next != null)
        {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur2.next = cur2.next.next;
        return head;
    }
}

/**
 * Notes: Two pointers. One pointers goes ahead with n nodes first
 * Then the second pointer proceed with the first one till the 
 * first one reach the last node. Then the second pointer perform
 * the deletion operation. 
 */