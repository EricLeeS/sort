package com.leetcode.PascalsTriangleII;

import java.util.ArrayList;

public class NewSolution {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int[] out = new int[rowIndex+1];
		int half = rowIndex>>1;
		for(int i=0;i<rowIndex+1;i++){
			if(i<=half){
        		out[i]=GetElement(rowIndex+1,i+1);
        		
        	}else{
        		out[i]=out[rowIndex-i];
        	}
        	System.out.print(out[i]+" ");
		}
		return null;
		
	}

	private int GetElement(int rowIndex, int i) {
		// TODO Auto-generated method stub
		if(i==0){
			return 0;
		}
		if(rowIndex==1||rowIndex==i){
			return 1;
		}
		else
			return GetElement(rowIndex-1,i-1)+GetElement(rowIndex-1,i);
		
	}
}
