package com.leetcode.InterleavingString;

public class Main {
	public static void main(String[] ars){
		String s1 = "aa";
		String s2 = "ab";
		String s3 = "abaa";
		NSolution so = new NSolution();
		System.out.println(so.isInterleave(s1, s2, s3));
	}
}
