package com.leetcode.MultiplyStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String multiply(String num1, String num2) {
    	if(num1.equalsIgnoreCase("")||num2.equalsIgnoreCase(""))
    		return "";
    	if(num1.equalsIgnoreCase("0")||num2.equalsIgnoreCase("0"))
    		return "0";
    	Map<Integer,String> map = new HashMap<Integer,String>();
    	map.put(0, "0");
    	map.put(1, num2);
    	for(int i=2;i<10;i++){
    		map.put(i, "");
    	}
    	char[] ch = new char[num1.length()*num2.length()+1];
    	Arrays.fill(ch, '0');
    	int xx=ch.length-1;
    	for(int i=num1.length()-1;i>=0;i--){
    		int temp = num1.charAt(i)-'0';
    		String base="";
    		if(map.get(temp).equalsIgnoreCase("")){
    			base=plus(temp,num2);
    			map.put(temp, base);
    		}else{
    			base=map.get(temp);
    		}
    		int x=xx;
    		int y=base.length()-1;
    		int pre=0;
    		while(y>=0){
    			int tt = base.charAt(y)-'0'+ch[x]-'0'+pre;
    			if(tt>=10){
    				pre=1;
    				ch[x]=String.valueOf(tt-10).charAt(0);
    			}else{
    				pre=0;
    				ch[x]=String.valueOf(tt).charAt(0);
    			}
    			x--;
    			y--;
    		}
    		if(pre!=0){
    			if(ch[x]!='0'){
    				int tm = ch[x]-'0'+pre;
    				if(tm>=10){
    					ch[x]='0';
    					ch[x-1]='1';
    				}else{
    					ch[x]=String.valueOf(tm).charAt(0);
    				}
    				
    			}else{
    				ch[x]='1';
    			}
    				
    		}
    		xx--;
    			
    	}
    	String re = String.valueOf(ch);
    	while(re.startsWith("0")){
    		re = re.substring(1);
    	}
		return re;
        
    }
    
    private String plus(int times,String base){
    	char[] ch = new char[base.length()+1];
    	ch[0]='0';
    	for(int m=base.length()-1;m>=0;m--){
    		ch[m+1]=base.charAt(m);
    	}
    	for(int j=1;j<times;j++){
    		int pre=0;
    		int i=base.length()-1;
    		int k=i+1;
    		while(i>=0){
    			int temp = base.charAt(i)-'0'+ch[k]-'0'+pre;
    			if(temp>=10){
    				pre=1;
    				ch[k]=String.valueOf(temp-10).charAt(0);
    			}else{
    				pre=0;
    				ch[k]=String.valueOf(temp).charAt(0);
    			}
    			i--;
    			k--;
    		}
    		if(pre!=0){
    			if(ch[k]!='0'){
    				int tm = ch[k]-'0'+pre;
    				if(tm>=10){
    					ch[k]='0';
    					ch[k-1]='1';
    				}else{
    					ch[k]=String.valueOf(tm).charAt(0);
    				}
    				
    			}else{
    				ch[k]='1';
    			}
    		}
    			
    		
    	}
    	if(ch[0]=='0'){
    		return String.valueOf(ch, 1, ch.length-1);
    		
    	}else{
    		return String.valueOf(ch);
    	}
    	
    }
}