package com.leetcode.PascalsTriangleII;

import java.util.ArrayList;

//用到可k方的 额外数据空间
public class NNewSolution {	
	 public ArrayList<Integer> getRow(int rowIndex) {
	    	ArrayList<Integer> ar = new ArrayList<Integer>();
	    	int half=rowIndex>>1;
	    	int[] out = new int[rowIndex+1];
	    	//out[0]=1;
	        int[][] sr = new int[rowIndex+1][rowIndex+1];
	        sr[0][0]=1;
	        for(int i=1;i<rowIndex+1;i++){
	        	for(int j=0;j<rowIndex+1;j++){
	        		int temp=0;
	        		if(j-1<0){
	        			temp=1;
	        		}else if(i==j){
	        			temp=1;
	        		}else{
	        			temp=sr[i-1][j-1]+sr[i-1][j];
	        		}
	        		sr[i][j]=temp;
	        	}
	        }
	        for(int i=0;i<rowIndex+1;i++){
	        	ar.add(sr[rowIndex][i]);
	        	//System.out.print(sr[rowIndex][i]+" ");
	        }
	        return ar;
	        
	    }
}
