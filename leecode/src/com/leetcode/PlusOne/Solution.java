package com.leetcode.PlusOne;

public class Solution {
    public int[] plusOne(int[] digits) {
		int temp=1;
		for(int i=digits.length-1;i>=0;i--){
			digits[i]+=temp;
			if(digits[i]>9){
				digits[i]-=10;
			}else{
				temp=0;
				break;
			}
		}
		
		if(temp==1){
			int[] re = new int[digits.length+1];
			re[0]=1;
			for(int i=0;i<digits.length;i++){
				re[i+1]=digits[i];
			}
			return re;
		}
    	return digits;
        
    }
}
