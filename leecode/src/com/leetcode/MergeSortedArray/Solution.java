package com.leetcode.MergeSortedArray;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i=m-1;
        int j=n-1;
        int index = m+n-1;
        int[] re = new int[index+1];
        while(i>-1&&j>-1){
        	if(A[i]>B[j]){
        		re[index]=A[i];
        		i--;
        		index--;
        		continue;
        	}
        	
        	if(A[i]<B[j]){
        		re[index]=B[j];
        		j--;
        		index--;
        		continue;
        	}
        	
        	if(A[i]==B[j]){
        		re[index]=B[j];
        		index--;
        		re[index]=B[j];
        		j--;
        		i--;
        		index--;
        		continue;
        	}
        }
        
        while(i>-1){
        	re[index]=A[i];
        	i--;
        	index--;
        }
        
        while(j>-1){
        	re[index]=B[j];
        	j--;
        	index--;
        }
        
        A=re;
    }
}
