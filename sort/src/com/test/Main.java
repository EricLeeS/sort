package com.test;

public class Main {
	public static void main(String[] args){
		System.out.println(fuc(2012,2102));
	}
	
	public static int fuc(int m, int n)

	{

		if ((m % n) == 0)

		{

			return n;

		}

		else

		{

			return fuc(n, m % n);

		}

	}
}
