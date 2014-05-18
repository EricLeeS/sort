package com.leetcode.Permutations;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		int[] num = {};
		ArrayList<ArrayList<Integer>> re = so.permute(num);
		for(int i=0;i<re.size();i++){
			ArrayList<Integer> temp = re.get(i);
			for(int j=0;j<temp.size();j++)
				System.out.print(temp.get(j));
			System.out.println("*******");
		}
	}
}
