package com.leetcode.SwapNodesinPairs;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
    	if(head!=null&&head.next!=null){
    		ListNode cur = head;
    		while(cur!=null&&cur.next!=null){
    			int temp = cur.val;
    			cur.val=cur.next.val;
    			cur.next.val=temp;
    			cur=cur.next.next;
    		}
    		return head;
    	}
		return head;
        
    }
}