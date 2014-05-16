package com.leetcode.PathSumII;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	if(root==null)
    		return re;
    	ArrayList<Integer> init = new ArrayList<Integer>();
    	int t=0;
    	PreOrder(root,init,t,sum);
		return re;
        
    }
    public ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
    private void PreOrder(TreeNode root, ArrayList<Integer> init,int t,int sum) {
		if(root!=null){
			t+=root.val;
			init.add(root.val);
			if(t==sum){
				if(root.left==null&&root.right==null){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.addAll(init);
					re.add(temp);
				}
			}
			
			PreOrder(root.left,init,t,sum);
			PreOrder(root.right,init,t,sum);
			t-=root.val;
			init.remove(init.size()-1);
		}
		
	}
	
    
}
