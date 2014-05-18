package com.leetcode.MultiplyStrings;

public class NSolution {
    public String multiply(String num1, String num2) {
    	String n1 = new StringBuilder(num1).reverse().toString();
    	String n2 = new StringBuilder(num2).reverse().toString();
    	int[] re = new int[n1.length()+n2.length()];
    	for(int i=0;i<n1.length();i++){
    		for(int j=0;j<n2.length();j++)
    			re[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int k=0;k<re.length;k++){
    		int low = re[k]%10;
    		int high = re[k]/10;
    		if(k+1<re.length)
    			re[k+1]+=high;
    		 sb.insert(0, low);
    	}
    	while(sb.charAt(0)=='0' && sb.length()>1){  
            sb.deleteCharAt(0);  
        }  
        return sb.toString();  
    }
 }
