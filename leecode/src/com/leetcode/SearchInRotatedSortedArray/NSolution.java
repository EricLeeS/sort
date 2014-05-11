package com.leetcode.SearchInRotatedSortedArray;
/**
 * （1）如果target==A[m]，那么m就是我们要的结果，直接返回；
（2）如果A[m]<A[r]，那么说明从m到r一定是有序的（没有受到rotate的影响），那么我们只需要判断target是不是在m到r之间，如果是则把左边缘移到m+1，否则就target在另一半，即把右边缘移到m-1。
（3）如果A[m]>=A[r]，那么说明从l到m一定是有序的，同样只需要判断target是否在这个范围内，相应的移动边缘即可。
 * @author huanli2
 *
 */
public class NSolution {
    public int search(int[] A, int target) {
    	int start = 0;
    	int end = A.length-1;
    	while(end>=start){
    		int mid = (end+start)/2;
    		if(A[mid]==target)
    			return mid;
    		
    		if(A[mid]<A[end]){
    			if(A[mid]<target&&A[end]>=target)
    				start=mid+1;
    			else
    				end=mid-1;
    		}else{
    			if(A[mid]>target&&A[start]<=target)
    				end=mid-1;
    			else
    				start=mid+1;
    		}
    	}
		return -1;
   
    }
}

