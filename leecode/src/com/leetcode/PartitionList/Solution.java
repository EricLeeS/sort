package com.leetcode.PartitionList;

public class Solution {
    public ListNode partition(ListNode head, int x) {
    	if(head==null||head.next==null)
    		return head;
    	ListNode root = head;
    	ListNode less = head;
    	ListNode re = head;
    	
    	if(head.val>=x){
    		ListNode tt = new ListNode(0);
    		root = tt;
    		ListNode pre = root;
    		root.next=head;
    		
    		while(less!=null){
    			if(less.val>=x){
    				pre=pre.next;
    				less=less.next;
    				continue;
    			}
    			ListNode temp = new ListNode(less.val);
    			temp.next=root.next;
    			root.next=temp;
    			root=temp;
    			
    			pre.next=less.next;    			
    			less=pre.next;		
    		}
    		re=tt.next;
    	}else{
    		root=head;
    		ListNode pre=head;
    		less=head.next;
    		while(less!=null){
    			if(less.val>=x){
    				pre=pre.next;
    				less=less.next;
    				continue;
    			}
    			ListNode temp = new ListNode(less.val);
    			if(root==pre){
    				root=root.next;
    				pre=pre.next;
    				less=less.next;
    			}else{
    				temp.next=root.next;
        			root.next=temp;
        			root=temp;
        			
        			pre.next=less.next;    			
        			less=pre.next;
    			}
    					
    		}
    	}
    			
    		
    	
		return re;
        
    }
}
