package com.leetcode.RemoveDuplicateFromSortedList;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	
    	if(head==null){
			return head;
		}else{
			ListNode root = head;
			ListNode pre = head;
			pre=head;
			int x=head.val;
			head=head.next;
			while(head!=null){
				if(head.val==x){
					pre.next=head.next;
					head=pre.next;
					
				}else{
					x=head.val;
					pre=head;
					head=head.next;
					
				}
			}
			return root;
		}
    	
        
    }
}
