package com.leetcode.ReverseInteger;

public class Solution {
	public int reverse(int x) {
		String strX = Integer.toString(x);
		int len = strX.length();
		StringBuffer dest = new StringBuffer(len);
		if (x >= 0) {
			for (int i = len - 1; i >= 0; i--) {
				dest.append(strX.charAt(i));
			}
		} else {
			dest.append('-');
			for (int i = len - 1; i >= 1; i--) {
				dest.append(strX.charAt(i));
			}
		}
		return Integer.parseInt(dest.toString());
	}
}