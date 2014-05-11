package com.leetcode.InsertionSortList;

//用到O（N）的额外空间
public class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if(head==null||head.next==null)
    		return head;
    	ListNode root = new ListNode(head.val);
    	ListNode cur = head.next;
    	while(cur!=null){
    		ListNode tempNode = root;
    		ListNode pre = root;
    		while(tempNode!=null){
    			if(cur.val>tempNode.val){
    				pre=tempNode;
    				tempNode=tempNode.next;
    			}else{
    				break;
    			}
    		}   		
    		if(tempNode==root){
    			ListNode newNode = new ListNode(cur.val);
    			newNode.next=root;
    			root=newNode;
    			cur=cur.next;
    		}else if(tempNode==null){
    			ListNode newNode = new ListNode(cur.val);
    			pre.next=newNode;
    			cur=cur.next;
    		}else{
    			ListNode newNode = new ListNode(cur.val);
    			pre.next=newNode;
    			newNode.next=tempNode;
    			cur=cur.next;
    		}
    		
    		
    	}
    	
		return root;
        
    }
}
