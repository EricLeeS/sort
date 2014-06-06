package com.leetcode.CombinationSumII;

import java.util.ArrayList;
import java.util.Iterator;


public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		int[] num = {10,1,2,7,6,1,5};
		ArrayList<ArrayList<Integer>> re = so.combinationSum2(num, 8);
		Iterator<ArrayList<Integer>> it = re.iterator();
		while(it.hasNext()){
			ArrayList<Integer> te = it.next();
			for(int i=0;i<te.size();i++){
				System.out.print(te.get(i));
			}
			System.out.println();
		}
	}
}
