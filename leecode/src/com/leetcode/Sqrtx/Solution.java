package com.leetcode.Sqrtx;
/*
 * ���ֲ��ҷ���ţ�ٵ�����
 * http://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html
 * http://kb.cnblogs.com/page/189867/
 * O��1���¼����Ӷ��ڽ��
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