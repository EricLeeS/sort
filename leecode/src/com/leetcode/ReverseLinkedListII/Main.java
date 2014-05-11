package com.leetcode.ReverseLinkedListII;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
//		ListNode l3 = new ListNode(3);
//		ListNode l4 = new ListNode(4);
//		ListNode l5 = new ListNode(5);
		l1.next=l2;
//		l2.next=l3;
//		l3.next=l4;
//		l4.next=l5;
		ListNode node = so.reverseBetween(l1,1,2);
		while(node!=null){
			System.out.println(node.val);
			node=node.next;
		}
	}
}
