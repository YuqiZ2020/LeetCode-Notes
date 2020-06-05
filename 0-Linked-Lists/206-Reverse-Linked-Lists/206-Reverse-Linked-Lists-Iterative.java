/**
 * Problem 206: Reverse Linked List
 * Prompt: Reverse a singly linked list.
 * Date: 06/03/2020
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
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode endMark = head;
        while (endMark.next != null)
            endMark = endMark.next;
        ListNode curRead = head;
        while (curRead != endMark)
        {
            ListNode temp = new ListNode(curRead.val);
            temp.next = endMark.next;
            endMark.next = temp;
            curRead = curRead.next;
        }
        return endMark;
    }
}

/**
 * Notes: Iterative solution. 
 * Find the end of the linked list. Make a copy of the node each time 
 * and then insert it right after the end marker. Finally return
 * the end marker. 
 * */