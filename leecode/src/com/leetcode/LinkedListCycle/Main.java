package com.leetcode.LinkedListCycle;

public class Main {
	public static void main(String[] args){
		ListNode first = new ListNode(1);
		
		ListNode second = new ListNode(4);
//		ListNode thord = new ListNode(3);
//		ListNode t1 = new ListNode(2);
//		ListNode t2 = new ListNode(5);
//		ListNode t3 = new ListNode(2);
		
		first.next=second;
//		second.next = thord;
//		thord.next=t1;
//		t1.next=t2;
//		t2.next = t3;
//		t3.next=first;
		Solution so = new Solution();
		boolean bol = so.hasCycle(first);
		System.out.println(bol);
	}
}
