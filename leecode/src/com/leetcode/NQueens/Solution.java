package com.leetcode.NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String[]> solveNQueens(int n) {
    	
    	if(n==0)
    		return re;
    	int[][] queen = new int[n][n];
    	for(int i=0;i<n;i++)
    		Arrays.fill(queen[i], 0);
    	
    	generate(0,n,queen);
		return null;
        
    }
    public List<String[]> re = new ArrayList<String[]>();
	private void generate(int count,int n, int[][] queen) {
		if(count==n){
			String[] res = new String[n];
			for(int i=0;i<n;i++){
				String str ="";
				for(int j=0;j<n;j++){
					if(queen[i][j]==1)
						str+="Q";
					else
						str+=".";
				}
				res[i]=str;
			}
			return;
		}
		
		
	}
}
