package com.microsoft.m10;
/**
 * 题目：输入一个已经按升序排序过的数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。要求时间复杂度是O(n)。
 * 如果有多对数字的和等于输入的数字，输出任意一对即可。
 * 例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
 * @author huanli2
 *http://zhedahht.blog.163.com/blog/static/2541117420072143251809/
 */
public class Main {
	public static void main(String[] args){
		int[] sr = {1,2,4,7,11,15};
		int k=15;
		int start=sr.length/2;
		int end=start+1;
		while(start>=0&&end<sr.length){
			if(sr[start]+sr[end]<k){
				end++;
			}else if(sr[start]+sr[end]>k){
				start--;
			}else{
				System.out.println(sr[start]+"+"+sr[end]+"="+k);
				break;
			}
		}
	}
}
