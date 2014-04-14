package com.leetcode.partionlist;

public class Solution {
    public ListNode partition(ListNode head, int x) {
		if(head==null){
			return null;
		}
		ListNode cur= head;
		int temp=0;
		while(cur!=null){
			temp = cur.val;
			if(temp<=x){
				continue;
			}
			if(temp>x){
				
			}
			
		}
    	return head;
        
    }
}