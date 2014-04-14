package com.leetcode.RemoveDuplicateFromSortedList;

public class Main {
	public static void main(String[] args){
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(1);
		ListNode t3 = new ListNode(2);
		ListNode t4 = new ListNode(3);
		ListNode t5 = new ListNode(3);
		t1.next=t2;
		t2.next=t3;
		t3.next=t4;
		t4.next=t5;
		Solution so = new Solution();
		so.deleteDuplicates(t1);
		
		
	}
}
