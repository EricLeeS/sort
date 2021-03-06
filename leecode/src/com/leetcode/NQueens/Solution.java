package com.leetcode.NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String[]> solveNQueens(int n) {
    	
    	if(n==0)
    		return re;
    	int[] queen = new int[n];
    	Arrays.fill(queen, 0);
    	
    	generate(0,n,queen);
		return re;
        
    }
    public List<String[]> re = new ArrayList<String[]>();
	private void generate(int count,int n, int[] queen) {
		if(count==n){
			String[] res = new String[n];			
			for(int i=0;i<n;i++){
				String str = "";
				for(int j=0;j<n;j++){
					if(j==queen[i])
						str+="Q";
					else
						str+=".";
				}
				res[i]=str;
			}
			re.add(res);
			return;
		}
		for(int i=0;i<n;i++){
			if(isValid(queen,count,i)){
				queen[count]=i;
				generate(count+1,n,queen);
			}
			queen[count]=0;
		}
		queen[count]=0;
		return;				
	}
	private boolean isValid(int[] queen, int n, int value) {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++){
			if(queen[i]==value||queen[i]-value==n-i||queen[i]-value==i-n)
				return false;
		}
		return true;
	}
}
