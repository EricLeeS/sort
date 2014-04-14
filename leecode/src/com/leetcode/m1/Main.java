package com.leetcode.m1;
import com.leetcode.m1.*;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		int[] sr={0,4,3,0};
		int target = 0;
		int[] re = so.twoSum(sr, target);
		for(int i=0;i<2;i++){
			System.out.println(re[i]);
		}
	}
}
