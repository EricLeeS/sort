package com.leetcode.LRUCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int capacity;
    Map<Integer,Integer> map;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map =new LRULinkedHashMap<Integer,Integer>(capacity);
       
    }
    
    public int get(int key) {
    	
    	if(map.containsKey(key))
    		return map.get(key);
    	
		return -1;
        
    }
    
    public void set(int key, int value) {
    	
        map.put(key, value);
        
    }
}
class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V>{  
    
    private int capacity;  
    private static final long serialVersionUID = 1L;  
   
    LRULinkedHashMap(int capacity){  
        
        super(16,0.75f,true);  
         
        this.capacity=capacity;  
    }  
    
    @Override  
    public boolean removeEldestEntry(Map.Entry<K, V> eldest){   
        
        return size()>capacity;  
    }    
}