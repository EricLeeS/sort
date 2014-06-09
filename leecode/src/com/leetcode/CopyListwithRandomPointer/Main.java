package com.leetcode.CopyListwithRandomPointer;

public class Main {
	public static void main(String[] args){
		RandomListNode rl1 = new RandomListNode(1);
		RandomListNode rl2 = new RandomListNode(2);
		RandomListNode rl3 = new RandomListNode(3);
		RandomListNode rl4 = new RandomListNode(4);
		RandomListNode rl5 = new RandomListNode(5);
		rl1.next=rl2;
		rl2.next=rl3;
		rl3.next=rl4;
		rl4.next=rl5;
		rl1.random=rl3;
		rl2.random=rl5;
		rl4.random=rl2;
		Solution so = new Solution();
		so.copyRandomList(rl1);
		
	}
}
