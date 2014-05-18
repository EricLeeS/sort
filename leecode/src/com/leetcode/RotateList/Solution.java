package com.leetcode.RotateList;

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
    	if(head==null||head.next==null||n==0)
    		return head;
    	int len = 0;
    	ListNode root = head;
    	while(root!=null){
    		root=root.next;
    		len++;
    	}
    	
    	ListNode fast = head;
    	ListNode slow = head;
    	int i=n%len;
    	if(i==0)
    		return head;
    	while(i>0&&fast!=null){
    		fast=fast.next;
    		i--;
    	}
    	
    	while(fast.next!=null){
    		slow=slow.next;
    		fast=fast.next;
    	}
    		
    	ListNode tem = slow.next;
    	fast.next=head;
        slow.next=null;
        return tem;
    		
        
    }
}
