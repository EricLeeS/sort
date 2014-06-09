package com.leetcode.MergekSortedLists;

import java.util.ArrayList;

public class Solution {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	
    	if(lists.size()==0)
    		return null;
    	if(lists.size()==1)
    		return lists.get(0);
    	ArrayList<ListNode> tl = new ArrayList<ListNode>();
    	while(lists.size()!=1){
    		for(int i=0;i<lists.size();i++){
        		if(i+1<lists.size()){
        			tl.add(merge(lists.get(i),lists.get(i+1)));
        			i=i+1;
        		}else{
        			tl.add(lists.get(i));
        		}
        	}
    		lists=new ArrayList<ListNode>();
    		lists.addAll(tl);
    		tl = new ArrayList<ListNode>();
    	}
    	
		return lists.get(0);
		
	}

	private ListNode merge(ListNode left, ListNode right) {
		// TODO Auto-generated method stub
		ListNode re = new ListNode(-1);
		ListNode root = re;
		while(left!=null&&right!=null){
			if(left.val>=right.val){
				ListNode temp = new ListNode(right.val);
				root.next=temp;
				root=root.next;
				right=right.next;
			}else{
				ListNode temp = new ListNode(left.val);
				root.next=temp;
				root=root.next;
				left=left.next;
			}
		}
		while(left!=null){
			ListNode temp = new ListNode(left.val);
			root.next=temp;
			root=root.next;
			left=left.next;
		}
		while(right!=null){
			ListNode temp = new ListNode(right.val);
			root.next=temp;
			root=root.next;
			right=right.next;
		}
		return re.next;
	}
}
