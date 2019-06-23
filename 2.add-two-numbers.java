/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode m, ListNode n) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (m != null || n!= null || carry != 0) {
            int value = carry;
            if (m != null) {
                value += m.val;
                m = m.next;
            }
            if (n != null) {
                value += n.val;
                n = n.next;
            }
            int digit = value % 10;
            carry = value / 10;
            tail.next = new ListNode(digit);
            tail = tail.next;
        }
        return dummy.next;
    }
}

