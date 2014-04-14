package com.leetcode.PascalsTriangleII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {
	    public ArrayList<Integer> getRow(int rowIndex) {
	    	ArrayList<Integer> ar = new ArrayList<Integer>();
	    	int half=rowIndex>>1;
	    	int[] out = new int[rowIndex+1];
	    	//out[0]=1;
	        for(int i=0;i<=rowIndex;i++){
	        	
	        	if(i<=half){
	        		out[i]=CC(rowIndex,i);
	        		
	        	}else{
	        		out[i]=out[rowIndex-i];
	        	}
	        	System.out.print(out[i]+" ");
	        }
			return ar;
	        
	    }
	    
	    //组合递归
	    public int C(int m,int n){
			if(n==0){
				return 1;
			}
			if(m==0){
				return 1;
			}
			if(m==n){
				return 1;
			}
	    	return C(m-1,n-1)+C(m-1,n);
	    	
	    }
	    //组合 非递归
	    public int CC(int high,int low){
	    	
	    	Stack<int[]> stack = new Stack<int[]>();
	    	int[] init={low,high};
	    	int sum=0;
	    	int flag=0;
	    	boolean bol = true;
	    	if(low==1){
	    		sum=high;
	    	}else{
	    		while(!stack.empty()||low<=high){
		    		bol=false;
		    		while(low>=0&&high>=1){
		    			int[] temp = {low,high};
		    			stack.push(temp);
		    			flag=1;
		    			low--;
		    			high--;
		    		}
		    		if(flag==1){
		    			low++;
			    		high++;
		    		}
		    		if(high==low){
		    			sum++;
		    			stack.pop();
		    		}else if(low==0||high==1){
		    			sum++;
		    			int[] temp =stack.peek();
		    			stack.pop();
		    		}
		    		//if(init[1]==1){}
		    		if(!stack.empty()){
		    			int[] temp = stack.peek();
		    			low=temp[0];
		    			high=temp[1];
		    			stack.pop();
		    			high--;
		    			
		    		}
		    		
		    		
		    	}
	    	}
	    	
	    	return sum;
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
} 