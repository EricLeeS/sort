package com.leetcode.PermutationsII;

import java.util.List;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		int[] num={11,11,2};
		List<List<Integer>> re = so.permuteUnique(num);
		for(int i=0;i<re.size();i++){
			for(int j=0;j<re.get(i).size();j++){
				System.out.print(re.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
}
