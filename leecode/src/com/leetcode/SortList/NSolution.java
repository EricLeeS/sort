package com.leetcode.SortList;
/**
 * mergr sort
 * @author huanli2
 *
 */
public class NSolution {
	public ListNode sortList(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
		ListNode slow =head;
		ListNode fast = head;
		ListNode temp = null;
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			temp =slow;
			slow=slow.next;
		}
		temp.next=null;
		
		return MergeSortSub(sortList(head),sortList(slow));
		
	}

	private ListNode MergeSortSub(ListNode sortList, ListNode sortList2) {
		// TODO Auto-generated method stub
		ListNode pre = new ListNode(0);
		ListNode root = pre;
		ListNode head1 = sortList;
		ListNode head2 = sortList2;
		ListNode cur=sortList;
		while(head2!=null&&head1!=null){
			if(head1.val>=head2.val){
				ListNode node= new ListNode(head2.val);
				pre.next=node;
				pre = node;
				head2=head2.next;
				continue;
			}
			if(head2.val>head1.val){
				ListNode node = new ListNode(head1.val);
				pre.next=node;
				pre = node;
				head1=head1.next;
				continue;
			}
		}
		
		while(head1!=null){
			ListNode node = new ListNode(head1.val);
			pre.next=node;
			pre = node;
			head1=head1.next;
		}
		while(head2!=null){
			ListNode node= new ListNode(head2.val);
			pre.next=node;
			pre = node;
			head2=head2.next;
		}
		
		return root.next;
	}
}
