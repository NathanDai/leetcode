/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start=new ListNode(0);
       start.next=head;
       int count=1;
       while(head!=null){
           count++;
           head=head.next;
       }
       ListNode pre=start;
       ListNode cur=start.next;
       for(int i=1;i<count-n;i++){
           cur=cur.next;
           pre=pre.next;
       }
       pre.next=cur.next;
       return start.next;
    }
}

