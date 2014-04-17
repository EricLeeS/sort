package com.leetcode.LinkedListCycleII;


public class Solution {
    public ListNode detectCycle(ListNode head) {
		boolean bol = hasCycle(head);
		if(bol){
			ListNode root = head;
			ListNode cc=root;
			ListNode cur = head;
			while(cur.next!=null){
				ListNode temp  = cur.next;
				cc.next=temp;
				cc=temp;
				cur.next=null;
				cur = temp;
				
			}
			head=root;
			return cur;
			
		}else{
			return null;
		}
    }

    
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
