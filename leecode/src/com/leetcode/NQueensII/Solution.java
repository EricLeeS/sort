package com.leetcode.NQueensII;

import java.util.Arrays;

public class Solution {
    public int totalNQueens(int n) {
    	if(n==0)
    		return 0;
    	int[] queen = new int[n];
    	Arrays.fill(queen, 0);
    	
    	generate(0,n,queen);
		return re;
        
    }
    public int re = 0;
    private void generate(int count, int n, int[] queen) {
		// TODO Auto-generated method stub
    	if(count==n){
			re++;
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
		for(int i=0;i<n;i++){
			if(queen[i]==value||queen[i]-value==n-i||queen[i]-value==i-n)
				return false;
		}
		return true;
	}
	
}
