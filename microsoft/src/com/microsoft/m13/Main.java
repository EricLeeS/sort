package com.microsoft.m13;
/**
 * 题目：在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b。
 * @author huanli2
 *
 */
public class Main {
	public static void main(String[] args){
		String sr = "abaccdeff";
		StringBuilder str1 = new StringBuilder("Slow");
		StringBuilder str2 = new StringBuilder("Medium");
		System.out.println(str1.reverse().toString().compareTo(str2.reverse().toString()));
	}
}
