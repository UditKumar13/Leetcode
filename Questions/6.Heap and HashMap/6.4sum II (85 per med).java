class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
      
      // we will use the hashmap to store the sum first 
      
      // this will be in n2logn
      HashMap <Integer,Integer> map = new HashMap<>() ;
      
      int c = nums3.length , d = nums4.length , b = nums2.length , a = nums1.length ; 
      
      for(int  i = 0 ; i< c; i++){
        for(int j =0 ; j < d ; j++){
          int sum = nums3[i]  + nums4[j] ; 
          map.put(sum , map.getOrDefault(sum,0) + 1 ); 
        }
      }
      
      
      // we have store the sum of all the pairs of nums3 and nums4 in our hashmap 
      
      // now we will count number of 4 pairs that have a summation of 0.
      int ans = 0 ; 
      for(int i =0 ; i< a; i++){
        for(int j =0 ; j<b ; j++){
          int sum = -(nums1[i] +nums2[j] );
          
          ans += map.getOrDefault(sum,0);
        }
      }
      
      return ans ; 
    }
}