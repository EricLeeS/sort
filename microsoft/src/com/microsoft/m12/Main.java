package com.microsoft.m12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.microsoft.m12.BSTreeNode;
/**
 *  题目：输入一颗二元树，从上往下按层打印树的每个结点，同一层中按照从左往右的顺序打印。
例如输入

      8
    /  \
   6    10
  /\     /\
 5  7   9  11

输出8   6   10   5   7   9   11。
 * @author huanli2
 *
 */
public class Main {
	public static void main(String[] args){
		BSTreeNode  root = new BSTreeNode (8);
		AddBSTreeNode(root,6);
		AddBSTreeNode(root,10);
		AddBSTreeNode(root,5);
		AddBSTreeNode(root,7);
		AddBSTreeNode(root,9);
		AddBSTreeNode(root,11);
		//Order(root);
		Order(root);
	}
/**
 * 用队列的先进先出的特点
 * @param root
 */
	private static void Order(BSTreeNode root) {
		// TODO Auto-generated method stub
		Queue<BSTreeNode> qu = new LinkedList<BSTreeNode>();
	
			qu.offer(root);
			while(qu.size()!=0){
				BSTreeNode node = qu.poll();
				System.out.println(node.getN());
				if(node.getLeft()!=null){
					qu.offer(node.getLeft());
				}
				if(node.getRight()!=null){
					qu.offer(node.getRight());
				}
			}
	}

	private static void AddBSTreeNode(BSTreeNode root, int i) {
		// TODO Auto-generated method stub
		if(i>root.getN()){
			if(root.getRight()!=null){
				AddBSTreeNode(root.getRight(),i);
			}else{
				BSTreeNode  node = new BSTreeNode (i);
				root.setRight(node);
			}
		}else if(i<root.getN()){
			if(root.getLeft()!=null){
				AddBSTreeNode(root.getLeft(),i);
			}else{
				BSTreeNode node = new BSTreeNode(i);
				root.setLeft(node);
			}
		}
	}
}
