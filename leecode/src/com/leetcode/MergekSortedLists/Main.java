package com.leetcode.MergekSortedLists;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args){
//		ListNode l1 = new ListNode(1);
//		ListNode l2 = new ListNode(3);
//		ListNode l3 = new ListNode(5);
//		ListNode l4 = new ListNode(8);
//		l1.next=l2;
//		l2.next=l3;
//		l3.next=l4;
//		ListNode l11 = new ListNode(2);
//		ListNode l22 = new ListNode(4);
//		ListNode l33 = new ListNode(9);
//		ListNode l44 = new ListNode(10);
//		l11.next=l22;
//		l22.next=l33;
//		l33.next=l44;
		ListNode l1 = new ListNode(1);
		ListNode l11 = null;
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(l11);
		lists.add(l1);
		Solution so = new Solution();
		ListNode re = so.mergeKLists(lists);
		while(re!=null){
			System.out.println(re.val);
			re=re.next;
		}
	}
}
