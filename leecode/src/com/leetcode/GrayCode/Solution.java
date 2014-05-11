package com.leetcode.GrayCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> re = new ArrayList<Integer>();
		int num = (int) (Math.pow(2, n)-1);
		int[] t = new int[n];
		for(int j=0;j<n;j++){
			t[j]=0;
		}
		int temp = 0;
		re.add(0);
		for(int i=0;i<num+1;i++){
			int[] tt = new int[n];
			tt[0]=t[0];
			for(int m=1;m<n;m++){
				tt[m]=t[m-1]^t[m];
			}
			re.add(ToNum(tt));
			for(int mm=0;mm<n;mm++){
				t[mm]=tt[mm];
			}
		}
		return re;
    }

	private Integer ToNum(int[] tt) {
		// TODO Auto-generated method stub
		int temp = 1;
		int re = 0;
		for(int i=tt.length-1;i>=0;i--){
			re+=(tt[i]*temp);
			temp*=2;
		}
		return re;
	}
}
