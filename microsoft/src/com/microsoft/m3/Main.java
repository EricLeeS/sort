package com.microsoft.m3;
/**
 * 3.求子数组的最大和
 * 题目：
 * 输入一个整形数组，数组里有正数也有负数。
 * 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * 例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2，
 * 因此输出为该子数组的和18。
 * @author huanli2
 *
 */
public class Main {
	/**
	 * 很容易理解，当我们加上一个正数时，和会增加；当我们加上一个负数时，和会减少。
	 * 如果当前得到的和是个负数，那么这个和在接下来的累加中应该抛弃并重新清零，不然的话这个负数将会减少接下来的和。
	 * @param args
	 */
	public static void main(String[] args){
		int[] sr={-1, -2, -3, -10, -4, -7, -2, -5};
		int sum=0;
		int max=0;
		for(int i=0;i<sr.length;i++){
			sum+=sr[i];
			if(sum<0){
				sum=0;
			}
			if(sum>max){
				max=sum;
			}
		}
		//如果所有的序列都是负值
		if(max==0){
			max=sr[0];
			for(int i=1;i<sr.length;i++){
				if(sr[i]>max){
					max=sr[i];
				}
			}
		}
		System.out.println(max);
	}
}
