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
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) 
        {
            fast = fast.next.next;
            
            ListNode nextTemp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextTemp;
        }
        if (fast != null)
            slow = slow.next;
        ListNode cur2 = prev;
        while (slow != null)
        {
            if (slow.val != cur2.val)
                return false;
            slow = slow.next;
            cur2 = cur2.next;
        }
        return true;
    }
}

/**
 * Notes: Use two pointers to determine the middle
 * part of the linked list. Meanwhile, use iterative
 * solution to reverse the first half. Then compare
 * the first half with the second half. 
 */