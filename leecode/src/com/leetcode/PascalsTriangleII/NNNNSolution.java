package com.leetcode.PascalsTriangleII;

import java.util.ArrayList;

public class NNNNSolution {
	public ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> ar = new ArrayList<Integer>();
        int[] sr = new int[rowIndex+1];
        sr[0]=1;
        int left=1;
        for(int i=1;i<rowIndex+1;i++){
        	for(int j=0;j<i+1;j++){
        		int temp=0;
        		if(j-1<0){
        			temp=1;
        		}else if(i==j){
        			temp=1;
        		}else{
        			
        			temp=sr[j]+left;
        			left = sr[j];
        		}
        		sr[j]=temp;
        	}
        }
        for(int i=0;i<rowIndex+1;i++){
        	ar.add(sr[i]);
        }
        return ar;
        
    }
}
