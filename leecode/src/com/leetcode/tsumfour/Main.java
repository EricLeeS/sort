package com.leetcode.tsumfour;

import java.util.ArrayList;
import java.util.Iterator;



public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		int[] num = {1,0,-1,0,-2,2};
		ArrayList<ArrayList<Integer>> re = so.fourSum(num, 0);
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
