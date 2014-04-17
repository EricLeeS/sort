package com.leetcode.PathSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
		boolean re = false;
    	if(root!=null){
			int init=0;
			boolean bol = false;
			PreOrder(root,init,sum);
		}
    	re=b;
    	return re;
        
    }
    public boolean b = false;
	private void PreOrder(TreeNode root,int init,int sum) {
		// TODO Auto-generated method stub
		
			if(root!=null){
				init+=root.val;
				if(init==sum){
					if(root.left==null&&root.right==null){
						b = true;
					}
				}
				PreOrder(root.left,init,sum);
				PreOrder(root.right,init,sum);
				init-=root.val;
			}
			
		}
}