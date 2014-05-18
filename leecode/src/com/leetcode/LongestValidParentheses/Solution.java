package com.leetcode.LongestValidParentheses;

import java.util.Arrays;

public class Solution {
    public int longestValidParentheses(String s) {
    	if(s.length()==0||s.length()==0)
    		return 0;
    	int[] re = new int[s.length()];
    	Arrays.fill(re, 0);
    	char[] ch = s.toCharArray();
    	char[] tch = new char[s.length()];
    	re[0]=0;
    	tch[0]=ch[0];
    	int max=0;
    	for(int i=1;i<s.length();i++){
    		//如果是右括号则直接定为0
    		if(ch[i]=='('){
    			tch[i]='(';
    			re[i]=0;
    		}
    		if(ch[i]==')'){
    			tch[i]=')';
    			int tt = i-1;
    			//找到左边第一个右括号
    			while(tt>=0&&re[tt]!=0){
    				tt--;
    			}
    			//如果不存在这样的右括号则设为0
    			if(tt<0){
    				re[i]=0;
    			}else{
    				//如果找到的是右括号
    				if(tch[tt]=='('){
    					//如果两个括号是相邻的
    					if(tt==i-1){
    						if(i-2<0)
    							re[i]=2;
    						else
    							re[i]=re[i-2]+2;
    					}else{
    						//如果两个括号不相邻
    						re[i]=re[i-1]+2;
    						//如果加上这个括号后，前面的对应括号 的前面也是相连的。。则再加上前面连续括号的长度
    						if(tt-1>=0&&tch[tt-1]==')'&&re[tt-1]!=0)
        						re[i]=re[tt-1]+re[i];
    					}
    					
    					if(re[i]>max)
    						max=re[i];
    					re[tt]=re[i];
    					
    				}else{
    					//如果找到的不是右括号
    					re[i]=0;
    				}
    			}
    				
    		}
    	}
		return max;
        
    }
}
