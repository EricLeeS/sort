package com.leetcode.PascalsTriangle;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
       if(numRows==0){
    	   return re;
       }else{
    	   int[][] sr = new int[numRows][numRows];
           ArrayList<Integer> temp = new ArrayList<Integer>(); 
           sr[0][0]=1;
           temp.add(sr[0][0]);
           re.add(temp);
           for(int i=1;i<numRows;i++){
           	temp = new ArrayList<Integer>();
           	for(int j=0;j<i+1;j++){
           		int temp1=0;
           		if(j-1<0){
           			temp1=1;
           		}else if(i==j){
           			temp1=1;
           		}else{
           			temp1=sr[i-1][j-1]+sr[i-1][j];
           		}
           		sr[i][j]=temp1;
           		temp.add(sr[i][j]);
           	}
           	re.add(temp);
           }
          
       	return re;
       }
    	
        
    }
}
