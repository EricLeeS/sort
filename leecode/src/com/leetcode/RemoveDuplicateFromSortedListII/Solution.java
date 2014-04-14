package com.leetcode.RemoveDuplicateFromSortedListII;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode root=new ListNode(0);
    	root.next=head;
		if(head==null){
			return head;
		}else{
			int x = head.val;
			ListNode pre = root;
			while(head!=null){
				if(head.next!=null){
					if(head.next.val==x){
						head = head.next;
						while(head.val==x){
							head=head.next;
							if(null==head){
								pre.next=null;
								return root.next;
							}
						}
						pre.next=head;
						x=head.val;
						if(head.next!=null){
							if(head.next.val==x){
								continue;
							}else{
								pre = head;
								head = head.next;
								x=head.val;
							}
						}
					}else{
						pre=head;
						head=head.next;
						x=head.val;
					}					
				}else{
					break;
				}
			}
		}
    	return root.next;
        
    }
}