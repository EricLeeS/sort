package com.leetcode.MergekSortedLists;

import java.util.ArrayList;

public class NSolution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	ListNode root = new ListNode(-1);
    	ListNode re = root;
    	if(lists.size()==0||lists.get(0)==null)
    		return null;
    	ListNode temp = new ListNode(-1);
    	
    	
    	int de=0;
    	while(lists.size()!=0){
    		int min=Integer.MAX_VALUE;
    		for(int i=0;i<lists.size();i++){
    			if(lists.get(i)==null){
    				lists.remove(i);
    				i=i-1;
    			}else if(lists.get(i).val<min){
    				de=i;
    				temp=lists.get(i);  
    				min=temp.val;
    			}     		
        	}
    		ListNode ln = new ListNode(temp.val);
    		root.next=ln;
    		root=ln;
    		lists.remove(de);
    		if(temp.next!=null)
    			lists.add(temp.next);
    		temp = new ListNode(-1);
    		
    	}
    	
		return re.next;
        
    }
}