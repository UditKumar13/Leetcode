import java.io.*;
import java.util.*;
class Solution {
    public static int twoSumUniquePairs(List<Integer> nums, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0) + 1);
        }
        int totPairs = 0;
        for(Map.Entry<Integer,Integer>it : map.entrySet()){
            int i = it.getKey();
            int freq = map.get(i);
            int rem = target - i;
            if(2*i == target && freq>1){
                totPairs += 2;
            }else if(map.contains(rem)){
                totPairs += 1;
            }
        }
        
        return totPairs/2;
      
    }
}