package com.microsoft.m10;
/**
 * ��Ŀ������һ���Ѿ�������������������һ�����֣��������в�����������ʹ�����ǵĺ�������������Ǹ����֡�Ҫ��ʱ�临�Ӷ���O(n)��
 * ����ж�����ֵĺ͵�����������֣��������һ�Լ��ɡ�
 * ������������1��2��4��7��11��15������15������4+11=15��������4��11��
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
