package com.leetcode.LongestPalindromicSubstring;

public class Main {
	public static void main(String[] args){
		String str = "aaabcaaaa";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!='a'){
				System.out.println(str.charAt(i));
				System.out.println(i);
			}
		}
		Solution so = new Solution();
		System.out.println(so.longestPalindrome(str));
	}
}
