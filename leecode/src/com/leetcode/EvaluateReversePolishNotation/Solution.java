package com.leetcode.EvaluateReversePolishNotation;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
    	Stack<String> stack = new Stack<String>();
    	if(tokens.length==0)
    		return 0;
    	
    	int[] op = new int[2];
    	Arrays.fill(op, 0);
    	
    	for(int i=0;i<tokens.length;i++){
    		if(!tokens[i].equals("+")&&!tokens[i].equals("-")&&!tokens[i].equals("*")&&!tokens[i].equals("/")){
    			stack.push(tokens[i]);
    			continue;
    		}else{
    			String operator = tokens[i];
    			op[1]=Integer.parseInt(stack.peek());
    			stack.pop();
    			op[0]=Integer.parseInt(stack.peek());
    			stack.pop();
    			int t=0;
    			switch(operator){
					case "+":t=op[0]+op[1];break;
					case "-":t=op[0]-op[1];break;
					case "*":t=op[0]*op[1];break;
					case "/":t=op[0]/op[1];break;
					default:t=0;break;
				}
    			stack.push(String.valueOf(t));   			
    		}
		
    	}
    	if(stack.isEmpty()||stack.peek().equals("+")||stack.peek().equals("-")||stack.peek().equals("*")||stack.peek().equals("/"))
    		return 0;
    	return Integer.parseInt(stack.peek());
    }
}
