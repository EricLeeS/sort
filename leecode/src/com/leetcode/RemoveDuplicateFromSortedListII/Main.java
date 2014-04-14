package com.leetcode.RemoveDuplicateFromSortedListII;



public class Main {
	public static void main(String[] args){
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(3);
		ListNode t4 = new ListNode(3);
		ListNode t5 = new ListNode(4);
		ListNode t6 = new ListNode(4);
		ListNode t7 = new ListNode(5);
		t1.next=t2;
		t2.next=t3;
		t3.next=t4;
		t4.next=t5;
		t5.next=t6;
		t6.next=t7;
		Solution so = new Solution();
		ListNode root = so.deleteDuplicates(t1);
		while(root!=null){
			System.out.println(root.val);
			root=root.next;
		}
		
	}
}
