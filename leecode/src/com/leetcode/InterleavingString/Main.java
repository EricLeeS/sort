package com.leetcode.InterleavingString;

public class Main {
	public static void main(String[] ars){
		String s1 = "accbaabaaabbcbaacbababacaababbcbabaababcaabbbbbcacbaa";
		String s2 = "cabaabcbabcbaaaacababccbbccaaabaacbbaaabccacabaaccbbcbcb";
		String s3 = "accbcaaabbaabaaabbcbcbabacbacbababaacaaaaacbabaabbcbccbbabbccaaaaabaabcabbcaabaaabbcbcbbbcacabaaacccbbcbbaacb";
		Solution so = new Solution();
		long startTime=System.currentTimeMillis();
		
		System.out.println(so.isInterleave(s1, s2, s3));
		long endTime=System.currentTimeMillis();
		System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");   
		
		
		
	}
}
