package com.leetcode.InsertionSortList;

public class NSolution {
    public ListNode insertionSortList(ListNode head) {
    	if(head==null||head.next==null)
    		return head;
    	
    	ListNode cur = head.next;
    	head.next=null;
    	while(cur!=null){
    		ListNode tempNode = head;
    		ListNode pre = head;
    		while(tempNode!=null){
    			if(cur.val>tempNode.val){
    				pre=tempNode;
    				tempNode=tempNode.next;
    			}else{
    				break;
    			}
    		}   		
    		if(tempNode==head){
    			ListNode newNode = new ListNode(cur.val);
    			newNode.next=head;
    			head=newNode;
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
    	
		return head;
        
    }
}