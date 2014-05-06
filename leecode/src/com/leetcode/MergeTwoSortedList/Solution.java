package com.leetcode.MergeTwoSortedList;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode re = node;
		while(l1!=null&&l2!=null){
			if(l1.val>l2.val){
				node.next=l2;
				l2=l2.next;
				
			}else{
				node.next=l1;
				l1=l1.next;
			}
			node=node.next;
		}
		while(l1!=null){
			node.next=l1;
			l1=l1.next;
			node=node.next;
		}
		while(l2!=null){
			node.next=l2;
			l2=l2.next;
			node=node.next;
		}
    	return re.next;
        
    }
}