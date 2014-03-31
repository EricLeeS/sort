package com.microsoft.m1;

import java.util.LinkedList;
import java.util.List;

public  class DoubleLinkedList {
	private static List<BSTreeNode> list = new LinkedList<BSTreeNode>();
	
	public static void addNode(BSTreeNode node){
		list.add(node);
	}
	public static List<BSTreeNode> getList(){
		return list;
	}
	
}
