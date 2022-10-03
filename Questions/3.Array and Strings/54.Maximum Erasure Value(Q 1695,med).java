class Solution {
    public int maximumUniqueSubarray(int[] nums) {
    Map<Integer,Integer> map = new HashMap<>();
    int ans = 0 ; 
    
    int i =- 1 ; 
    int j = - 1 ;
    int sum = 0;
    while(true){
      boolean f1 = false ; 
      boolean f2 = false ; 
      // acquire
      while (i < nums.length-1){
        
        f1 =true ; 
        i ++ ;
        
        int curr = nums[i];
        
        map.put(curr,map.getOrDefault(curr,0) + 1) ;
        
        if (map.get(curr) == 2){
          sum += curr;
          break ; // because we don't want unique characters
        }
        
        else {
           sum += curr;
           ans = Math.max(ans,sum);
        }
        
      }
      
      
      while (j<i){
        f2 = true ; 
        j++ ; 
        
        int curr =  nums[j];
        
        map.put(curr, map.get(curr)-1) ;
        
        if (map.get(curr) ==1){
          sum -= curr;
          break ;  // if the character is only 1 that means it is unique now lets acquire more coming out of this loop
        }
          
        sum -= curr;
      }
      
      
      if (f1 ==false && f2 ==false ){
        break ; // coming out of the while true loop 
      }
    }
    
    
    
		
		return ans;
    }
}