class Solution {
    public int longestConsecutive(int[] arr) {
  
      
      HashMap <Integer, Integer> map = new HashMap<>() ;
      int max = 0 ;
      
      for(int i=0; i< arr.length ; i++){
        
        if (!map.containsKey(arr[i])){
        // checking one less and one more number 
        // in the map if those are there they insfres the connsecutive ele ,then acc to their nature we update the map for the current ele  
        int left = map.containsKey(arr[i]-1) ?map.get(arr[i]-1)  :0 ;
        int right = map.containsKey(arr[i]+1) ?map.get(arr[i]+1)  :0 ;
        
        int sum = left + right + 1 ;
        
        map.put(arr[i],sum) ; 
        if(sum > max){
          max = sum ; 
        }
          
          // updating the boundaries 
          
          map.put(arr[i]-left, sum) ;  // left boundaries 
          map.put(arr[i] + right , sum) ; 
      }
      
      else {
        // simply continue 
        continue ; 
      }
      }
      
      return max ; 
      
    }
}