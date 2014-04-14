package com.tree.order;

import java.util.Stack;

public class Tree { 
	private	BinaryTreeNode one;
	public Tree(){
		one = new BinaryTreeNode("1");
		BinaryTreeNode two = new BinaryTreeNode("2");
		BinaryTreeNode three = new BinaryTreeNode("3");
		BinaryTreeNode four = new BinaryTreeNode("4");
		BinaryTreeNode five = new BinaryTreeNode("5");
		BinaryTreeNode six = new BinaryTreeNode("6");
		BinaryTreeNode seven = new BinaryTreeNode("7");
		BinaryTreeNode eight = new BinaryTreeNode("8");
		BinaryTreeNode nine = new BinaryTreeNode("9");
		BinaryTreeNode ten = new BinaryTreeNode("10");
		one.setLlink(two);
		one.setRlink(three);
		two.setLlink(four);
		two.setRlink(five);
		three.setLlink(six);
		three.setRlink(seven);
		four.setLlink(eight);
		four.setRlink(nine);
		five.setLlink(ten);
		
	}
	public BinaryTreeNode getRoot(){
		return one;
	}
	/**
	 * 递归中续遍历
	 * @param cur 根节点
	 */
	public void inOrder(BinaryTreeNode cur){
		if(cur!=null){
			inOrder(cur.getLlink());
			System.out.println(cur.getInfo());
			inOrder(cur.getRlink());
		}
	}
	/**
	 * 非递归实现中续遍历
	 * @param cur
	 */
	public void nonInOrder(BinaryTreeNode cur){
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();  
		while(cur!=null||!stack.empty()){
			if(cur!=null){
				stack.push(cur);
				cur = cur.getLlink();
			}else{
				cur = stack.peek();
				System.out.println(cur.getInfo());
				stack.pop();
				cur=cur.getRlink();
			}
		} 
		
	}
	/**
	 * 递归前序遍历
	 * @param cur
	 */
	public void preOrder(BinaryTreeNode cur){
		if(cur!=null){
			System.out.println(cur.getInfo());
			preOrder(cur.getLlink());
			preOrder(cur.getRlink());
			
		}
	}
	/**
	 * 非递归实现前序遍历
	 * @param cur
	 */
	public void nonPreOrder(BinaryTreeNode cur){
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(cur!=null||!stack.empty()){
			if(cur!=null){
				System.out.println(cur.getInfo());
				stack.push(cur);
				cur=cur.getLlink();
				continue;
			}else{
				cur=stack.peek().getRlink();
				stack.pop();
			}
		}
	}
	/**
	 * 递归后序遍历
	 * @param cur
	 */
	public void postOrder(BinaryTreeNode cur){
		if(cur!=null){
			
			postOrder(cur.getLlink());
			postOrder(cur.getRlink());
			System.out.println(cur.getInfo());
		}
	}
	/**
	 * 非递归后序遍历实现
	 * @param cur
	 */
	public void nonPostOrder(BinaryTreeNode cur){
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode pre=null;
		while(cur!=null||!stack.empty()){
			while(cur!=null){
				stack.push(cur);
				cur=cur.getLlink();
			}
			cur = stack.peek();
			if(cur.getRlink()==null||cur.getRlink()==pre){
				System.out.println(cur.getInfo());
				pre = cur;
				stack.pop();
				cur=null;
			}else{
				cur=cur.getRlink();
			}
			
		}
	}
	
	
	
}
