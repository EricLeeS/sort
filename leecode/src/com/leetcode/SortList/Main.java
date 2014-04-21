package com.leetcode.SortList;

public class Main {
	public static void main(String[] args){
		ListNode t1 = new ListNode(4);
		ListNode t2 = new ListNode(5);
		ListNode t3 = new ListNode(3);
		ListNode t4 = new ListNode(6);
		ListNode t5 = new ListNode(7);
		t1.next=t2;
		t2.next=t3;
		t3.next=t4;
		t4.next=t5;
		NSolution so = new NSolution();
		ListNode re = so.sortList(t1);
		while(re!=null){
			System.out.println(re.val);
			re=re.next;
		}
	}
}
