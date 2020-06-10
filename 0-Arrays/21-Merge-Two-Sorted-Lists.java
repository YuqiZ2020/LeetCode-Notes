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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode cur1;
        ListNode cur2;
        ListNode head;
        if (l1.val < l2.val)
        {
            cur1 = l1;
            cur2 = l2;
            head = l1;
        }
        else
        {
            cur1 = l2;
            cur2 = l1;
            head = l2;
        }
        while (cur2 != null)
        {
            if (cur1.next == null)
            {
                cur1.next = cur2;
                break;
            }
            int val1 = cur1.next.val;
            int val2 = cur2.val;
            if (val1 < val2)
                cur1 = cur1.next;
            else
            {
                ListNode templ2 = cur2.next;
                cur2.next = cur1.next;
                cur1.next = cur2;
                cur2 = templ2;
                cur1 = cur1.next;
            }
        }
        return head;
    }
}

/**
 * Notes: first determine which head is smaller to be
 * the final head. Then for the other linked list, 
 * maintain a pointer to compare the value with the value
 * on the main list. If the value of the main list is smaller
 * just skip to the next node; otherwise perform insertion
 * and go to the next node. 
 */