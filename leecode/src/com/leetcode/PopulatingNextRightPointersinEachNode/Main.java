package com.leetcode.PopulatingNextRightPointersinEachNode;

public class Main {
	public static void main(String[] args){
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		TreeLinkNode t6 = new TreeLinkNode(6);
		TreeLinkNode t7 = new TreeLinkNode(7);
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		t1.left=t2;
		t1.right=t3;
		Solution so = new Solution();
		so.connect(t1);
	}
}
