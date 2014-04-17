package com.leetcode.RemoveNthNodeFromEndofList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
		int i=0;
		ListNode fast=head;
		ListNode slow=head;
		if(n==1){
			while(i<n&&fast!=null){
				fast=fast.next;
				i++;
			}
			if(null==fast){
				return null;
			}
			while(fast.next!=null){
				
				fast=fast.next;
				
				slow=slow.next;
				
			}
			if(fast.next==null){
				slow.next=null;
				
			}
			return head;
			
		}
		while(i<n-1&&fast!=null){
			fast=fast.next;
			i++;
		}
		if(null==fast){
			return null;
		}
		
		while(fast.next!=null){
			
			fast=fast.next;
			
			slow=slow.next;
			
		}
		if(fast.next==null){
			if(slow.next==null){
				return null;
			}else{
				slow.val=slow.next.val;
				slow.next=slow.next.next;
			}
			
		}
		
    	return head;
        
    }
}
