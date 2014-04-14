package com.leetcode.m1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OldSolution {
    public int[] twoSum(int[] numbers, int target) {
    	 Map<Integer,Integer> station = new HashMap<Integer, Integer>();
     int index1=0;
     int index2=0;
     int[] re =new int[2];
     for(int i=0;i<numbers.length;i++){
       if((station.size()!=0)&&(station.containsKey(numbers[i]))){
         if((numbers[i]+numbers[i])==target){
            index1=station.get(numbers[i]);
            index2=i;
            index1++;
            index2++;
            re[0]=index1;
            re[1]=index2;
            return re;
         }else{
            continue;
         }
       }else{
         station.put(numbers[i], i);
       }
     }
     for(int j=0;j<numbers.length;j++){
       int temp = target-numbers[j];
       station.remove(numbers[j]);
       if(station.containsKey(temp)){
         index1=j;
         index2=station.get(temp);
         break;
       }else{
         station.put(numbers[j], j);
       }
       
     }
     index1++;
     index2++;
     if(index1>index2){
       int temp = index1;
       index1=index2;
       index2=temp;
     }
     re[0]=index1;
     re[1]=index2;
     return re;

    }
}