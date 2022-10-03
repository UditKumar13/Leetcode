class Solution {
  
    public int missingNumber(int[] arr) {
    // XOR  operator will going to work 
      
      int xor = 0, i =0   ;
      
      for (i =0; i<arr.length ; i++){
        xor = xor ^ i ^ arr[i] ;  // we are using the fact that index and val are following xor prop
      }
      
      return xor ^ i ; // it will definately give the missing number
      
      
    
    }
}