package com.leetcode.CombinationSum;

import java.util.ArrayList;
import java.util.Iterator;


public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		int[] num = {2,3,6,7};
		ArrayList<ArrayList<Integer>> re = so.combinationSum(num, 7);
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
