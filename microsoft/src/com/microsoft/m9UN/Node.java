package com.microsoft.m9UN;

public class Node {
	private int n;
	private Node node;
	public Node(int N){
		this.n=N;
	}
	public Node getNext(){
		return node;
	}
	public void setNode(Node next){
		this.node=next;
	}
}
