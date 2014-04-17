package com.leetcode.anagrams;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		String[] str ={"car","car","car","god","dog"};
		ArrayList<String> ar = so.anagrams(str);
		for(String temp:ar){
			System.out.println(temp+"***");
		}
	}
}
