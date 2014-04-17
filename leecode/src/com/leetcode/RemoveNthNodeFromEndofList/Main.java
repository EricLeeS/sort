package com.leetcode.RemoveNthNodeFromEndofList;

public class Main {
	public static void main(String[] args){
		ListNode no =new ListNode(1);
		ListNode t2 =new ListNode(2);
//		ListNode t3 = new ListNode(3);
//		ListNode t4 = new ListNode(4);
		no.next=t2;
		Solution so = new Solution();
		so.removeNthFromEnd(no, 1);
	}
}
