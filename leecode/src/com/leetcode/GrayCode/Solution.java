package com.leetcode.GrayCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * http://www.cnblogs.com/lihaozy/archive/2012/12/31/2840437.html
 * @author Administrator
 *Gray Code， 每次看每次都不记得。写下来让自己好温习。

Gray Code 0 = 0, 下一项是toggle最右边的bit(LSB), 再下一项是toggle最右边值为 “1” bit的左边一个bit。然后重复

如： 3bit

Gray Code:  000, 001, 011, 010, 110, 111, 101, 100, 最右边值为 “1” 的bit在最左边了，结束。

Binary      :  000, 001, 010, 011, 100, 101, 110, 111

 

再者就是Binary Code 转换为Gray Code了。

如：

　　Binary Code ：1011 要转换成Gray Code

　　1011 = 1（照写第一位）, 1(第一位与第二位异或 1^0 = 1), 1(第二位异或第三位， 0^1=1), 0 (1^1 =0) = 1110

　　其实就等于 (1011 >> 1) ^ 1011 = 1110
 */
public class Solution {
    public List<Integer> grayCode(int n) {
		int size = 1 << n;		
		List<Integer> ret = new ArrayList<Integer>();
		
		for(int i=0; i<size; i++){
			
			ret.add(i ^ (i>>1));
		}
		return ret;
	}
}
