package com.leetcode.ReverseNodesinkGroup;


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	ListNode root = head;
    	while(root!=null){
    		ListNode temp = root;
    		ListNode tempRoot = root;
    		int i=k;
    		i--;
    		while(i!=0&&k>0&&temp!=null){
    			temp=temp.next;
    			i--;
    		}
    		if(temp==null){
    			return head;
    		}else{
    			root = temp.next;
    			int j=k;
    			while(j!=0&&j>0){
    				ResK(tempRoot,j-1);
    				tempRoot=tempRoot.next;
    				j=j-2;
    			}
    		}
    		
    	}
		return head;
        
    }

	private void ResK(ListNode head, int swap) {
		ListNode temp = head;
		while(swap!=0){
			swap--;
			temp=temp.next;		
		}
		int tt = temp.val;
		temp.val=head.val;
		head.val=tt;
			
		
	}
}