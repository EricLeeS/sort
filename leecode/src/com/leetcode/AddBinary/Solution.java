package com.leetcode.AddBinary;

import java.util.Arrays;

public class Solution {
    public String addBinary(String a, String b) {
    	if(a.equalsIgnoreCase("")||a==null)
    		return b;
    	if(b.equalsIgnoreCase("")||b==null)
    		return a;
    	int i=a.length()-1;
    	int j=b.length()-1;
    	int[] in = new int[Math.max(a.length(), b.length())+1];
    	Arrays.fill(in, 0);
    	int k=in.length-1;
    	while(i>=0&&j>=0){
    		in[k]=a.charAt(i)-'0'+b.charAt(j)-'0';
    		k--;
    		j--;
    		i--;
    	}
    	if(i==-1){
    		while(j>=0){
    			in[k]=b.charAt(j)-'0';
    			j--;
    			k--;
    		}
    	}
    	if(j==-1){
    		while(i>=0){
    			in[k]=a.charAt(i)-'0';
    			i--;
    			k--;
    		}
    	}
    	int pre = 0;
    	for(int m=in.length-1;m>=0;m--){
    		int temp = in[m]+pre;
    		pre = temp/2;
    		in[m]=temp%2;
    	}
    	StringBuilder sb = new StringBuilder();
    	int init=0;
    	if(in[0]==0)
    		init=1;
    	while(init<in.length){
    		sb.append(in[init]);
    		init++;
    	}
    	
		return sb.toString();
        
    }
}
