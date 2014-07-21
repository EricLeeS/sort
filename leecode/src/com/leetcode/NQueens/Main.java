package com.leetcode.NQueens;

import java.util.List;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		List<String[]> re = so.solveNQueens(4);
		for(int i=0;i<re.size();i++){
			String[] s = re.get(i);
			for(int j=0;j<s.length;j++)
				System.out.print(s[j]+" ");
			System.out.println();
		}
	}
}
