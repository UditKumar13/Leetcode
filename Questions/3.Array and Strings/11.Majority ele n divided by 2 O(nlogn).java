/*
Problem :

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
*/


class Solution {
    public int majorityElement(int[] nums) {
      Arrays.sort(nums) ;
     int mid = (nums.length-1)/2 ; 
     return nums[mid];
      
      
    }
}




Approach 2 : Using the Hashmap 

/*
Problem :

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
*/


class Solution {
    public int majorityElement(int[] nums) {
    
      HashMap <Integer,Integer> map = new HashMap<>() ;
      int max = 0; 
      if(nums.length >=1){
        max =1 ; 
      }
    
      for (int val : nums){
        if (map.containsKey(val) == true){
          int nf =  map.get(val) + 1;
          if(nf >max){
            max = nf ; 
          }
          map.put(val,nf);
        }
        
        else {
          map.put(val,1);
          
        }
      }
      
      int ans = 0 ; 
      for(int val : nums){
        int freq = map.get(val);
        
        if(freq == max){
          ans = val ; 
          break ; 
        }
      }
      
      return ans ; 
    }
}