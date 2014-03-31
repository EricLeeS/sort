package com.microsoft.m6;
/**
 * http://zhedahht.blog.163.com/blog/static/25411174200725319627/
 * 题目：输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。如果是返回true，否则返回false。
例如输入5、7、6、9、11、10、8，由于这一整数序列是如下树的后序遍历结果：

         8
       /  \
      6    10
    / \    / \
   5   7   9  11

因此返回true。

如果输入7、4、6、5，没有哪棵树的后序遍历的结果是这个序列，因此返回false。
 * @author huanli2
 *
 */
public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args){
		//int[] sr={5,7,6,9,11,10,8};
		int[] sr={7,4,6,5};
		Boolean bol = verifySquenceOfBST(sr,0,sr.length-1);
		System.out.println(bol);
	}
/**
 * 结题思路： 既然是后续遍历，最后一个是根节点，那根节点前面比根节点小，
 * 后面的比根节点小，以此伟临界点，
 * 临界点后面不可能再出现比根节点小的点了，如果出现则不满足后续遍历
 * @param sr
 * @param start
 * @param end
 * @return
 */
	private static Boolean verifySquenceOfBST(int[] sr,int start,int end) {
		// TODO Auto-generated method stub
		Boolean bol=true;
		if(end>=start){
			int root = sr[end];
			int i=0;
			for(i=start;i<end-1;i++){
				if(sr[i]>root){
					bol=verifySquenceOfBST(sr,start,i-1);
					bol=verifySquenceOfBST(sr,i,end-1);
				}
			}
			
			for(int j=i;j<end;j++){
				if(sr[j]<root){
					bol=false;
				}
			}	
		}
		
		return bol;
	}
}
