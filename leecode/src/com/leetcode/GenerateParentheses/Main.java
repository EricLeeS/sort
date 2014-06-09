package com.leetcode.GenerateParentheses;

import java.util.List;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		List<String> re = so.generateParenthesis(5);
		for(int i=0;i<re.size();i++){
			System.out.println(re.get(i));
		}
	}
}
