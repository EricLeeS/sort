package com.microsoft.m8UN;

public class Sum {
	private static int i=0;
	private static int sum=0;
	Sum(){
		++i;
		sum+=i;
	}
	public static int getSum(){
		return sum;
	}
}
