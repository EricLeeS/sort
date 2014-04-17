package com.leetcode.LinkedListCycleII;

public class NSolution {
	public ListNode detectCycle(ListNode head) {
		ListNode fast,slow;
		if(head==null){
			return null;
		}
		
		slow=head;
		fast=head;
		
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next;
			fast=fast.next;
			if(slow==fast){
				break;
			}
		}
		
		if(fast==null||fast.next==null){
			return null;
		}
	    
		slow=head;
		if(slow==fast){
			return slow;
		}
		
		while(true){
			slow=slow.next;
			fast=fast.next;
			if(slow==fast){
				break;
			}
		}
		
		return slow;
	}

}
