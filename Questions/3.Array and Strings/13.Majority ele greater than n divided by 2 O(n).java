 /*
Problem :

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array. 

Solution :
https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
*/


class Solution {
  
  
  // moore Voting algo 
    public int majorityElement(int[] nums) {

      // moore voting algorithm 
      int ret = 0, count =0  ; 
      for(int num : nums){
        
        if(count == 0 ){
          ret = num ; 
        }
        
        if(num != ret){
          
          count -- ; 
        }
        
        else {
          count ++ ; 
        }
      }
      return ret ; 
      
    }
}