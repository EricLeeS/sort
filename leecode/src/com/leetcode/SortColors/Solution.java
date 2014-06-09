package com.leetcode.SortColors;

public class Solution {
    public void sortColors(int[] A) {
       if(A.length==0||A.length==1)
    	   return;
       for(int i=1;i<A.length;i++){
    	   if(!(A[i]>=A[i-1])){
    		   for(int j=i;j>0;j--){
    			   if(!(A[j]>=A[j-1])){
    				   int temp = A[j];
    				   A[j]=A[j-1];
    				   A[j-1]=temp;
    			   }
    		   }
    	   }
       }
       
    }
}
