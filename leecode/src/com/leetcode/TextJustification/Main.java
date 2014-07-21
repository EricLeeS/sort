package com.leetcode.TextJustification;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		String[] str = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
		Solution so = new Solution();
		ArrayList<String> re = so.fullJustify(str, 30);
		for(int i=0;i<re.size();i++){
			System.out.println(re.get(i));
			System.out.println(re.get(i).length());
		}
			
			
	}
}
