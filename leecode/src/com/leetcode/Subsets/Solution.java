package com.leetcode.Subsets;
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> ntemp = new ArrayList<Integer>();
		List<ArrayList<Integer>> list = new LinkedList<ArrayList<Integer>>();
		List<ArrayList<Integer>> templist = new LinkedList<ArrayList<Integer>>();
		Map<ArrayList<Integer>,Integer> mapre = new HashMap<ArrayList<Integer>,Integer>();
		ArrayList<Integer> artemp = new ArrayList<Integer>();
		ArrayList<Integer> ttemp = new ArrayList<Integer>();
		int nnum=0;
		re.add(ntemp);
		if(S.length==0){
			return re;
		}else{
			Arrays.sort(S);
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			for(int i=0;i<S.length;i++){
				ntemp=new ArrayList<Integer>();
				ntemp.add(S[i]);
				ArrayList<Integer> mappp = new ArrayList<Integer>();
				int ttt = Integer.valueOf(S[i]);
				mappp.add(ttt);
				if(mapre.containsKey(ntemp)){
					
				}else{
					list.add(ntemp);
					mapre.put(mappp, nnum);
				}
				
				if(map.containsKey(S[i])){
					int num =map.get(S[i]);
					num++;
					map.put(S[i],num);
				}else{
					map.put(S[i], 1);
				}
				
			}
			
			for(int j=1;j<S.length;j++){
				int stemp=S[j];
				List<ArrayList<Integer>> temp=new LinkedList<ArrayList<Integer>>();
				
				
				Iterator<ArrayList<Integer>> it = list.iterator();

				
				Iterator<ArrayList<Integer>> newit = list.iterator();
				while(newit.hasNext()){
					artemp = new ArrayList<Integer>();
					ttemp = new ArrayList<Integer>();
					artemp.clear();
					ttemp.clear();
					artemp=newit.next();
					Iterator<Integer> itt = artemp.iterator();
					while(itt.hasNext()){
						ttemp.add(itt.next());
					}
					temp.add(ttemp);
					if(artemp.get(artemp.size()-1)<=stemp){
						artemp.add(stemp);

						if(!mapre.containsKey(artemp)){
							Iterator<Integer> artempit = artemp.iterator();
							int count=0;
							while(artempit.hasNext()){
								if(artempit.next()==stemp){
									count++;
								}
							}
							if(!(count>map.get(stemp))){
								temp.add(artemp);
								Iterator<Integer> or = artemp.iterator();
								ArrayList<Integer> al = new ArrayList<Integer>();
								while(or.hasNext()){
									al.add(or.next());
								}
								
								mapre.put(al, nnum++);
							}
							
						}
						
					}
				}
				list = temp;
			}

			re.addAll(list);
			
			
			
			return re;
		}
    	
        
    }
}
