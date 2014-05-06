package com.leetcode.RemoveDuplicatesfromSortedArrayII;

public class Solution {
    public int removeDuplicates(int[] A) {
		if(A.length==0)
			return 0;
		int pre = A[0];
		int count = 1;

		int tempcount=1;
		for(int i=1;i<A.length;i++){
			if(A[i]==pre){
				if(tempcount>=2){
					continue;
				}else{
					count++;
					A[count-1]=A[i];
					tempcount++;
				}
				
			}else{
				pre = A[i];
				tempcount=1;
				count++;
				A[count-1]=A[i];
			}
		}
    	
    	return count;
        
    }
}
