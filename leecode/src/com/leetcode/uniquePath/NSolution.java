package com.leetcode.uniquePath;
/**
 * DP
 * @author huanli2
 *
 */
public class NSolution {

	  public int uniquePaths(int m, int n) {

	    if(m<=0||n<=0)

	      return 0;

	    if(1==m||n==1)

	      return 1;

	    int[] map =new int[n+1];

	    for(int i=1;i<n+1;i++)

	       map[i]=1;

	    for(int x=2;x<m+1;x++){

	      for(int y=2;y<n+1;y++){

	         map[y]+=map[y-1];

	       }

	        

	      }

	    

	      return map[n];

	  }

	}
