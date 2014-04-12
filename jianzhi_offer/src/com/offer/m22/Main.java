package com.offer.m22;

import java.util.Stack;

public class Main {
	public static void main(String[] args){
		int[] in = {1,2,3,4,5};
		int[] out={4,5,3,2,1};
		if((in.length!=out.length)||in.length==0){
			System.out.println("the length must be equal");
		}else{
			Boolean bol = IsStackOutQuene(in,out);
			System.out.println(bol);
		}
		
	}

	private static Boolean IsStackOutQuene(int[] in, int[] out) {
		// TODO Auto-generated method stub
		Boolean bol = true;
		Stack<Integer> stack = new Stack<Integer>();
		int inlength = in.length;
		int outlength = out.length;
		int i=0;
		int j=0;
		while(i<=in.length&&j<=out.length){
			if(stack.size()!=0){
				if(out[j]==stack.peek()){
					stack.pop();
					j++;
					continue;
				}else if(i<in.length){
					if(in[i]==out[j]){
						i++;
						j++;
						continue;
					}else{
						stack.push(in[i]);
						i++;
						continue;
					}
				}else{
					bol = false;
					break;
				}
				
				
				 
			}else if(i==in.length&&j==out.length){
				bol=true;
				break;
			}else if(stack.size()==0){
				if(in[i]==out[j]){
					i++;
					j++;
					continue;
				}else{
					stack.push(in[i]);
					i++;
					continue;
				}
			}
			
		}
		return bol;
	}
}
