
/*
https://www.zetone.in/apply.html
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.


Solution : https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.

*/
class Solution {
    public int findDuplicate(int[] nums) {
        
    // we have to use the condition n integer, n+1 
      
    int slow = nums[0] ;
    int fast = nums[nums[0]] ; // becuase of n+1 condition  
      
      
    while(nums.length > 1){
      
      // let us find the meeting point by tortoise hare algo 
      
      while(slow != fast){
        slow = nums[slow] ; // 1 jump
        fast = nums[nums[fast]] ;  // 2 jump
      }
      
      fast = 0 ;
      
      // now start tortoise from meeting pt. and hare from the starting but this time with 1 jump
       
      while(slow!=fast){
        slow = nums[slow] ;
        fast = nums [fast] ; 
      }
      
      return slow ; 
    }
    
    return -1 ;   
    }
  
  
}