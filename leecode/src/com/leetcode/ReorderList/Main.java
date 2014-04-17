package com.leetcode.ReorderList;


public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
//		ListNode t3=new ListNode(3);
//		ListNode t4=new ListNode(4);
		t1.next=t2;
//		t2.next=t3;
//		t3.next=t4;
		ListNode root=so.reorderList(t1);
		while(root!=null){
			System.out.println(root.val);
			root=root.next;
		}
	}
}
