/**
 * Problem 430: Flatten a Multilevel Doubly Linked List
 * Prompt: You are given a doubly linked list which in addition to 
 * the next and previous pointers, it could have a child pointer, 
 * which may or may not point to a separate doubly linked list. 
 * These child lists may have one or more children of their own, 
 * and so on, to produce a multilevel data structure, as shown in 
 * the example below.
 * Flatten the list so that all the nodes appear in a single-level, 
 * doubly linked list. You are given the head of the first level 
 * of the list.
 * Date: 07/10/2020
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) 
    {
        dfs(head, null);
        return head;
    }
    public void dfs(Node cur, Node end)
    {
        while (cur != null && cur.child == null)
            cur = cur.next;
        if (cur == null)
            return;
        //Save current next element and link the child
        Node temp = cur.next;
        cur.next = cur.child;
        cur.next.prev = cur;
        cur.child = null;
        dfs(cur.next, temp);
        //Go to the end and relink the temp back
        while (cur.next != null)
            cur = cur.next;
        cur.next = temp;
        if (temp != null)
            cur.next.prev = cur;
        
    }
}

/**
 * Notes: This is a recursive function. 
 * First step is to find the first node that has a child node. 
 * We first save the next node of that current node, and then 
 * linke the child node onto it. Then we dfs to deal with the next
 * node. 
 * After this we find the end of the current list and relink the
 * nodes that we previously saved back. 
 */