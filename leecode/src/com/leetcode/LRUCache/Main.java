package com.leetcode.LRUCache;

public class Main {
	public static void main(String[] args){
		LRUCache lru = new LRUCache(2);
		lru.set(2,1);
		lru.set(1,1);
		lru.set(2,3);
		lru.set(4,1);
		lru.get(1);
		lru.get(2);
//		lru.set(1, 2);
		
	}
}
