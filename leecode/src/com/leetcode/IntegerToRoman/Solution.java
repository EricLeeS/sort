package com.leetcode.IntegerToRoman;

public class Solution {
    public String intToRoman(int num) {
    	StringBuilder sb = new StringBuilder();
    	if(num==0)
    		return sb.toString();
    	while(num!=0){
    		if(num>=1000){
    			int temp = num/1000;
    			for(int i=0;i<temp;i++)
    				sb.append("M");
    			num = num%1000;
    			continue;
    		}
    		if(num>=500){
    			if(num/900==1){
    				sb.append("CM");
    				num=num%900;
    				continue;
    			}
    			num = num%500;
    			sb.append("D");
    			
    		}
    		if(num>=100){
    			if(num/400==1){
    				sb.append("CD");
    				num=num%400;
    				continue;
    			}
    			int temp = num/100;
    			for(int i=0;i<temp;i++)
    				sb.append("C");
    			num=num%100;
    			continue;
    		}
    		if(num>=50){
    			if(num/90==1){
    				sb.append("XC");
    				num=num%90;
    				continue;
    			}
    			num=num%50;
    			sb.append("L");
    			continue;
    		}
    		if(num>=10){
    			if(num/40==1){
    				sb.append("XL");
    				num=num%40;
    				continue;
    			}
    			int temp = num/10;
    			for(int i=0;i<temp;i++)
    				sb.append("X");
    			num=num%10;
    			continue;
    		}
    		if(num>=5){
    			if(num/9==1){
    				sb.append("IX");
    				num=num%9;
    				continue;
    			}
    			num=num%5;
    			sb.append("V");
    			continue;
    		}
    		if(num>=1){
    			if(num/4==1){
    				sb.append("IV");
    				num=num%4;
    				continue;
    			}
    			int temp = num;
    			for(int i=0;i<temp;i++)
    				sb.append("I");
    			num=0;
    			continue;
    		}
    	}
		return sb.toString();
        
    }
}