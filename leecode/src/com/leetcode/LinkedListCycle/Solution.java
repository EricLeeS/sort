package com.leetcode.LinkedListCycle;

public class Solution {
    public boolean hasCycle(ListNode head) {
		boolean bol = false;
		if(head==null){
			bol = false;
		}else if(head.next==null){
			bol = false;
		}else{
			ListNode slow = head;
			ListNode fast = head;
			boolean s = false;
			while(slow!=null&&fast!=null){
				if(s){
					if(slow.equals(fast)){
						bol=true;
						break;
					}
				}
				s=true;
				slow=slow.next;
				fast = fast.next;
				if(fast!=null){
					fast=fast.next;
				}else{
					bol = false;
					break;
				}
			}
		}
    	return bol;
        
    }
}