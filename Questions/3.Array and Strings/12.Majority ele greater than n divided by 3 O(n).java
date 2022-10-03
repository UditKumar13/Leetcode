/*

Problem : Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Solution  : https://leetcode.com/problems/majority-element-ii/discuss/63500/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!

https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
*/

class Solution {
    public List<Integer> majorityElement(int[] arr) {
        
      if (arr.length == 0 || arr == null) {
        return new ArrayList<Integer>() ; 
      }
      
      ArrayList <Integer> result = new ArrayList<Integer>() ; 
      // step 1 : to find the strongest 2 candidates for the majority ele > 3
      int num1 = arr[0], num2 = arr[0], c1 = 0 , c2 = 0 ; 
      int len = arr.length ; 
      for (int  i =0 ; i< len ; i++){
        
        
        if(num1 == arr[i]){
          c1 ++ ; 
        }
        
        else if (num2 == arr[i]){
          c2 ++ ; 
        }
        
        else if (c1 == 0 ){
          num1 = arr[i] ;
          c1 = 1 ; 
        }
        
        
        else if(c2 ==0){
          num2 =arr[i] ;
          
          c2 = 1 ; 
        }
        
        else {
          c1 -- ;
          c2 -- ; 
        }
      }
      
      // till now we got our num1 and num2 candidates now 
      
      // step 2 : validation by the condition 
      if(num1 == num2){
        num2 = Integer.MAX_VALUE;
        // for breaking the duplicacy 
      }
      c1 = 0 ;
      c2 = 0; 
      
      for (int num : arr){
        if (num == num1){
          c1++ ; 
        }
        
        if(num == num2){
          c2++ ; 
        }
      }
      
      
      // condition for n>3
      
        
      if(c1 > len/3){
        result.add(num1) ;
      }
      
      if(c2>len/3){
        result.add(num2);
      }
      
     
      return result ; 
    }
}