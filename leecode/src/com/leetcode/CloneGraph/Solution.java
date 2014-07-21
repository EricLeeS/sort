package com.leetcode.CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	UndirectedGraphNode root = new UndirectedGraphNode(node.label);
    	UndirectedGraphNode head = root;
    	Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
    	set.add(node);
    	ArrayList<UndirectedGraphNode> list = node.neighbors;
    	ArrayList<UndirectedGraphNode> temp = new ArrayList<UndirectedGraphNode>();
    	Map<UndirectedGraphNode,ArrayList<UndirectedGraphNode>> map = new HashMap<UndirectedGraphNode,ArrayList<UndirectedGraphNode>>();
    	while(!list.isEmpty()){
    		for(int i=0;i<list.size();i++){
    			UndirectedGraphNode tn = list.get(i);
    			if(!set.contains(tn)){
    				UndirectedGraphNode nn = new UndirectedGraphNode(tn.label);
    				
    			}
    		}
    	}
		return node;
        
    }

	private void dfs(UndirectedGraphNode node, UndirectedGraphNode root,
			Set<UndirectedGraphNode> set) {
		ArrayList<UndirectedGraphNode> list = node.neighbors;
		
		
	}
}
