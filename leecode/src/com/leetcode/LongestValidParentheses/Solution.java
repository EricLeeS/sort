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
    		//�������������ֱ�Ӷ�Ϊ0
    		if(ch[i]=='('){
    			tch[i]='(';
    			re[i]=0;
    		}
    		if(ch[i]==')'){
    			tch[i]=')';
    			int tt = i-1;
    			//�ҵ���ߵ�һ��������
    			while(tt>=0&&re[tt]!=0){
    				tt--;
    			}
    			//�������������������������Ϊ0
    			if(tt<0){
    				re[i]=0;
    			}else{
    				//����ҵ�����������
    				if(tch[tt]=='('){
    					//����������������ڵ�
    					if(tt==i-1){
    						if(i-2<0)
    							re[i]=2;
    						else
    							re[i]=re[i-2]+2;
    					}else{
    						//����������Ų�����
    						re[i]=re[i-1]+2;
    						//�������������ź�ǰ��Ķ�Ӧ���� ��ǰ��Ҳ�������ġ������ټ���ǰ���������ŵĳ���
    						if(tt-1>=0&&tch[tt-1]==')'&&re[tt-1]!=0)
        						re[i]=re[tt-1]+re[i];
    					}
    					
    					if(re[i]>max)
    						max=re[i];
    					re[tt]=re[i];
    					
    				}else{
    					//����ҵ��Ĳ���������
    					re[i]=0;
    				}
    			}
    				
    		}
    	}
		return max;
        
    }
}
