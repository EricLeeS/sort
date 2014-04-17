package com.leetcode.Subsets;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args){
		int[] src = {1,1,1,1};
		
		Solution so = new Solution();
		ArrayList<ArrayList<Integer>> re =so.subsets(src);
		Iterator<ArrayList<Integer>> it =re.iterator();
		while(it.hasNext()){
			ArrayList<Integer> temp = it.next();
			Iterator<Integer> itt = temp.iterator();
			while(itt.hasNext()){
				System.out.print(itt.next()+" ");
			}
			System.out.println();
		}
	}
}
