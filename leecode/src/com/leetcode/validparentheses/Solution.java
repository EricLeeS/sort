package com.leetcode.validparentheses;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
    	if(s.equalsIgnoreCase("")){
    		return false;
    	}else{
    		Stack<Character> stack = new Stack<Character>();
    		Map<Character,Character> map =new HashMap<Character,Character>();
    		map.put('(',')');
    		map.put(')','(');
    		map.put('[',']');
    		map.put(']','[');
    		map.put('{','}');
    		map.put('}','{');
    		for(int i=0;i<s.length();i++){
    			char ch = s.charAt(i);
    			if(stack.isEmpty()){
    				stack.push(ch);
    			}else{
    				if(stack.peek()==map.get(ch)){
    					stack.pop();
    				}else{
    					stack.push(ch);
    				}
    			}
    		}
    		if(stack.isEmpty()){
    			return true;
    		}else{
    			return false;
    		}
    	}
        
    }
}
