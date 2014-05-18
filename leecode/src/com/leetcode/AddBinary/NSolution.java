package com.leetcode.AddBinary;

import java.util.Arrays;

public class NSolution {
    public String addBinary(String a, String b) {
    	if(a.equalsIgnoreCase("")||a==null)
    		return b;
    	if(b.equalsIgnoreCase("")||b==null)
    		return a;
    	int i=a.length()-1;
    	int j=b.length()-1;
    	char[] in = new char[Math.max(a.length(), b.length())+1];
    	Arrays.fill(in, '0');
    	int k=in.length-1;
    	while(i>=0&&j>=0){
    		in[k]=String.valueOf(a.charAt(i)-'0'+b.charAt(j)-'0').charAt(0);
    		k--;
    		j--;
    		i--;
    	}
    	if(i==-1){
    		while(j>=0){
    			in[k]=String.valueOf(b.charAt(j)-'0').charAt(0);
    			j--;
    			k--;
    		}
    	}
    	if(j==-1){
    		while(i>=0){
    			in[k]=String.valueOf(a.charAt(i)-'0').charAt(0);
    			i--;
    			k--;
    		}
    	}
    	int pre = 0;
    	for(int m=in.length-1;m>=0;m--){
    		int temp = in[m]-'0'+pre;
    		pre = temp/2;
    		in[m]=String.valueOf(temp%2).charAt(0);
    	}
    
    	if(in[0]=='0')
    		return String.valueOf(in).substring(1);
    	else
    		return String.valueOf(in);
    	
        
    }
}

