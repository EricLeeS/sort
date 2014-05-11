package com.leetcode.InsertionSortList;

public class Main {
	public static void main(String[] args){
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(6);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		NSolution so = new NSolution();
		ListNode l = so.insertionSortList(l1);
		while(l!=null){
			System.out.println(l.val);
			l=l.next;
		}
	}
}
