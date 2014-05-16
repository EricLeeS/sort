package com.leetcode.FlattenBinaryTreetoLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public void flatten(TreeNode root) {
    	if(root==null)
    		return;
    	LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        PreOrder(list,root);
        Iterator<TreeNode> it = list.iterator();
        TreeNode re = new TreeNode(root.val);
        TreeNode init = re;
        
        while(it.hasNext()){
        	TreeNode temp = it.next();
        	re.right=new TreeNode(temp.val);
        	re=re.right;
        }
        root.left=null;
        root.right=null;
        root = init.right;
        String str;
    }

	private void PreOrder(LinkedList<TreeNode> re, TreeNode root) {
		if(root!=null){
			re.add(root);
			PreOrder(re,root.left);
			PreOrder(re,root.right);
		}
		
	}
}
