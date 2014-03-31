package com.microsoft.m1;

public class BSTreeNode {
	private int value;
	private BSTreeNode left;
	private BSTreeNode right;
	private BSTreeNode prev;
	private BSTreeNode next;
	public BSTreeNode(int value){
		this.value=value;
	}
	public BSTreeNode getLeft() {
		return left;
	}
	public void setLeft(BSTreeNode left) {
		this.left = left;
	}
	public BSTreeNode getRight() {
		return right;
	}
	public void setRight(BSTreeNode right) {
		this.right = right;
	}
	public int getValue() {
		return value;
	}
	public BSTreeNode getPrev() {
		return prev;
	}
	public void setPrev(BSTreeNode prev) {
		this.prev = prev;
	}
	public BSTreeNode getNext() {
		return next;
	}
	public void setNext(BSTreeNode next) {
		this.next = next;
	}
	
}
