package com.leetcode.AddTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
        	return l2;
        if(l2==null)
        	return l1;
        ListNode root = new ListNode(0);
        ListNode re = root;
        int pre = 0;
        
        while(l1!=null&&l2!=null){
        	int sum = l1.val+l2.val+pre;
        	ListNode temp = new ListNode(sum%10);
        	root.next=temp;
        	root = temp;
        	pre = sum/10;
        	l1=l1.next;
        	l2=l2.next;
        }
        while(l1!=null&&l2==null){
        	int sum = l1.val+pre;
        	ListNode temp = new ListNode(sum%10);
        	root.next=temp;
        	root=temp;
        	pre = sum/10;
        	l1=l1.next;
        }
        while(l2!=null&&l1==null){
        	int sum = l2.val+pre;
        	ListNode temp = new ListNode(sum%10);
        	root.next=temp;
        	root=temp;
        	pre = sum/10;
        	l2=l2.next;
        }
        if(pre!=0){
        	ListNode temp = new ListNode(1);
        	root.next=temp;
        }
        return re.next;
    }
}
