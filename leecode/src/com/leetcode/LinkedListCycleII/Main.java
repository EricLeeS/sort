package com.leetcode.LinkedListCycleII;


public class Main {
	public static void main(String[] args){

		ListNode t1 = new ListNode(-1);
		ListNode t2 = new ListNode(-7);
		ListNode t3 = new ListNode(7);
		ListNode t5 = new ListNode(-4);
		ListNode t6 = new ListNode(19);
		ListNode t7 = new ListNode(6);
		ListNode t8 = new ListNode(-9);
		
		ListNode t9 = new ListNode(-5);
		ListNode t10 = new ListNode(-2);
		ListNode t11= new ListNode(-5);
		t1.next=t2;
		t2.next=t3;
		t3.next=t5;
		t5.next=t6;
		t6.next=t7;
		t7.next=t8;
		t8.next=t9;
		t9.next=t10;
		t10.next=t11;
		t11.next=t7;
		NSolution so = new NSolution();
		ListNode bol = so.detectCycle(t1);
		System.out.println(bol.val);
	}
}
