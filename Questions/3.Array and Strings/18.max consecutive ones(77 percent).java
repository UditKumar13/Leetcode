class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        
      
    int max = 0 , curr = 0 ;
      
      for (int num : arr){
        // here we are just looking at the number if it is 1 we increase curr by 1 else 0
        max = Math.max(max,curr = num == 0 ? 0 : curr + 1  );
      }
      
      return max ;
    
      
    }
    }