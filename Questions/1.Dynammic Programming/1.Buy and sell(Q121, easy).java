class Solution {
    public int maxProfit(int[] arr) {
     
      if (arr.length == 0){
        return 0 ; 
      }
        // we will apply the max so far and min so far technique  
      
      // similar to the kadane's algorithm 
   
      int bought = arr[0] ; 
      int max_Far =0; 
      for (int i = 1 ; i< arr.length ; i++){
        
        if (bought <arr[i]){
          max_Far = Math.max(max_Far , arr[i] - bought ) ; 
        }
        
        else {
         bought = arr[i] ; // focus on next element  
        }
      }
      
    return max_Far ; 
}
  
}

// Intution :

bought ko phla ele maan lo, then for 1 to len, check kro if new ele is big than bought if it is take max of the differnce, if not make curr ele bought.

