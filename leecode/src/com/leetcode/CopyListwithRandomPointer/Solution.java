package com.leetcode.CopyListwithRandomPointer;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head==null)
    		return head;
    	RandomListNode rl = new RandomListNode(0);
    	RandomListNode temp = new RandomListNode(0);
    	RandomListNode re = null;
    	rl=head;
    	while(rl!=null){
    		temp = new RandomListNode(rl.label);
    		temp.next=rl.next;
    		rl.next=temp;
    		rl=temp.next;
    	}
    	rl=head;
    	while(rl!=null){
    		if(rl.random!=null){
    			rl.next.random=rl.random.next;
    		}else{
    			rl.next.random=null;
    		}
    		rl=rl.next.next;
    	}
    	rl=new RandomListNode(0);
    	temp=head;
    	while(temp!=null){
    		rl.next=temp.next;
    		if(re==null)
    			re=rl.next;
    		rl=rl.next;
    		temp.next=temp.next.next;
    		temp=temp.next;
    	}
    	
		return re;
        
    }
}
