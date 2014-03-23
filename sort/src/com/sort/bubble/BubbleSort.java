package com.sort.bubble;
/**
 * 
 * @author huanli2
 *from max to min
 *ц╟ещеепР
 */
public class BubbleSort {
	public static void main(String[] args){
		int[] sr = {194,638,124,482,469,245,852,294,484,243,623}; 
		int count=1;
		int num=0;
		while(count!=0){
			count=0;
			System.out.println("the "+(num++)+" iteration");
			for(int i=0;i<sr.length;i++){
				if(i!=sr.length-1){
					if(sr[i]<sr[i+1]){
						int temp=sr[i+1];
						sr[i+1]=sr[i];
						sr[i]=temp;
						count++;
					}
				}
				System.out.print("   "+sr[i]);
			}
			System.out.println("\n");
		}
		
		
	}
}
