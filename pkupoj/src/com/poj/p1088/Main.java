package com.poj.p1088;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int count=106;
	static int r;
	static int c;
	static int d[][] = new int[count][count];
	static int lens[][] = new int[count][count];

	public static void main(String[] args) throws FileNotFoundException {
		//File f = new File("c:\\data.txt");
		//Scanner cin = new Scanner(f);
		 Scanner cin = new Scanner(System.in);

		// 输入数据
		r = cin.nextInt();
		c = cin.nextInt();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				d[i][j] = cin.nextInt();
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				// 对于每一个点都dp
				dp(i, j);
			}
		}
		int max = -Integer.MAX_VALUE;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (max < lens[i][j])
					max = lens[i][j];
			}
		}
		System.out.println(max);
	}

	static int dp(int i, int j) {

		// 记忆搜索。如果已经处理过，那么直接返回
		if (lens[i][j] > 0) {
			return lens[i][j];
		}
		int len1 = 0;
		int len2 = 0;
		int len3 = 0;
		int len4 = 0;
		if (j - 1 >= 0) {
			if (d[i][j - 1] < d[i][j]) {
				len1 = dp(i, j - 1);
			}
		}
		if (i - 1 >= 0) {
			if (d[i - 1][j] < d[i][j]) {
				len2 = dp(i - 1, j);
			}
		}
		if (j + 1 < c) {
			if (d[i][j + 1] < d[i][j]) {
				len4 = dp(i, j + 1);
			}
		}
		if (i + 1 < r) {
			if (d[i + 1][j] < d[i][j]) {
				len3 = dp(i + 1, j);
			}
		}

		// 记忆搜索
		int tlen = 1 + get4max(len1, len2, len3, len4);
		lens[i][j] = tlen;
		return tlen;
	}

	static int get4max(int a, int b, int c, int d) {
		return max(a, b) > max(c, d) ? max(a, b) : max(c, d);
	}

	static int max(int a, int b) {
		return a > b ? a : b;
	}
}
