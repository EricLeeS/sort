package com.leetcode.ReverseLinkedListII;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(m==n||m>n)
    		return head;
    	int len = n-m;
    	ListNode root = head;
    	m--;
    	while(m!=0&&root!=null){
    		root = root.next;
    		m--;
    	}
    	ListNode cur = root;
    	while(len!=0&&len>0){
    		ListNode temp = cur;
    		int i=len;
    		while(i!=0){
    			temp=temp.next;
    			i--;
    		}
    			
    		int tempv = cur.val;
    		cur.val=temp.val;
    		temp.val=tempv;
    		len-=2;
    		cur=cur.next;
    	}
    	
		return head;
        
    }
}
