package com.leetcode.ScrambleString;

public class Main {
	public static void main(String[] args){
		String s1 = "abcdefghijklmnopq";
		String s2 = "efghijklmnopqcadb";
		Solution so = new Solution();
		Long start = System.currentTimeMillis();
		System.out.println(so.isScramble(s1, s2));
		Long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
