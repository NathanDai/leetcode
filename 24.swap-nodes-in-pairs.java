/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode H = new ListNode(0);
        ListNode p = H;
        
        if(head == null || head.next == null) return head;
        
        while(head!=null && head.next!=null)
        {
            ListNode t = head.next.next;
            p.next = head.next;
            p = p.next;
            p.next = head;
            p = p.next;
            head = t;
        }
        p.next = head;
        return H.next;
        
    }
}

