package com.leetcode.Sqrtx;
/*
 * 二分查找法和牛顿迭代法
 * http://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html
 * http://kb.cnblogs.com/page/189867/
 * O（1）事件复杂度内解决
 */
public class Solution {
	public	int sqrt(int x) {
		      if (x == 0) return 0;
		      double last = 0;
		      double res = 1;
		      while (res != last)
		      {
		         last = res;
		          res = (res + x / res) / 2;
		      }
		     return (int) (res);
		 }
}
