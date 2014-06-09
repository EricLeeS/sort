package com.leetcode.ZigZagConversion;

public class Main {
	public static void main(String[] args){
		String s="PAYPALISHIRING";
		Solution so = new Solution();
		String re = so.convert(s, 3);
		System.out.println(re);
	}
}
