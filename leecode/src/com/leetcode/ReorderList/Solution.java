package com.leetcode.ReorderList;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ListNode reorderList(ListNode head) {
    	ListNode root = head;
        if(head!=null&&head.next!=null){
        	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        	root = head;
        	int num=0;
        	while(root!=null){
        		map.put(num, root.val);
        		root=root.next;
        		num++;
        	}
        	ListNode cur;
        	int count=0;
        	cur = head;
        	ListNode tempNode;
        	ListNode pre = null;
        	int leng=num/2;
        	while(cur.next!=null&&count<leng){
        		
        		tempNode = cur.next;
        		int temp = num-count-1;
        		if(temp==count){
        			break;
        		}
        		ListNode node = new ListNode(map.get(temp));
        		pre=node;
        		cur.next=node;
        		node.next=tempNode;
        		cur = tempNode;
        		count++;
        		
        	}
        	if(num%2==0){
        	    pre.next=null;
        	}else{
        	    pre.next.next=null;
        	}
        }
        return head;
    }
}
