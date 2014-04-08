package com.offer.m6;

public class BSTreeNode {
	private BSTreeNode left;
	private BSTreeNode right;
	private int info;
	public BSTreeNode(int info){
		this.info=info;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
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
}
