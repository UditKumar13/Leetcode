class Solution {
    public int subarraySum(int[] arr, int k) {
    
      
      // subarray sum equals k 
      
      // Brute force O(n^2)
      
      // optimized 
      
      // O(n) Tc O(n) SC
      Map <Integer, Integer> map = new HashMap <>() ;
      // sum,how many times this sum came before 
      int sum = 0 ,res = 0 ;
      map.put(0,1) ; // this is trick it will sure that we get a right subaaray sum
      
      for (int  i =0 ; i<arr.length ; i++){
        
        
        sum+= arr[i] ;
        int remaining_sum = sum - k  ;
        if (map.containsKey(remaining_sum)){
          res +=  map.get(remaining_sum);
        }
        
        // do this always
        
        map.put(sum,map.getOrDefault(sum,0)+1);
      }
      
      
      return res ; 
    }
}