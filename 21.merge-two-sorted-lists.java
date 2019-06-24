/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = null;
        ListNode resCurr = null;
        if (l1.val < l2.val) {
            res = l1;
            resCurr = res;
            l1 = l1.next;
        } else {
            res = l2;
            resCurr = res;
            l2 = l2.next;   
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                resCurr.next = l1;
                l1 = l1.next;
                resCurr = resCurr.next;
            } else {
                resCurr.next = l2;
                l2 = l2.next;
                resCurr = resCurr.next;
            }
        }
        while (l1 != null) {
            resCurr.next = l1;
            l1 = l1.next;
            resCurr = resCurr.next;
        }
        while (l2 != null) {
            resCurr.next = l2;
            l2 = l2.next;
            resCurr = resCurr.next;
        }
        return res;
    }
}

