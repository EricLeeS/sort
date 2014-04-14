package com.tree.order;

public class Main {
	public static void main(String[] args){
		Tree t = new Tree();
		//t.inOrder(t.getRoot());
		t.postOrder(t.getRoot());
		t.nonPostOrder(t.getRoot());
	}
}
