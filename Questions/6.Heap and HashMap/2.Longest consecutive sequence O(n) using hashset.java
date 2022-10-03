class Solution {
    public int longestConsecutive(int[] arr) {
  
      
      // using set 
      if(arr == null || arr.length == 0) return 0 ; 
      Set <Integer> set = new HashSet<>() ;
      
      int max =1 ; 
       for(int num: arr) set.add(num);
      for(int num : arr){
        
        if(set.remove(num)){
          int val = num ; 
          int sum =1 ; 
          
          while(set.remove(val-1)) val-- ;
          
          sum += num - val ; 
          
          // update val  once again 
          val = num ; 
          while(set.remove(val +1)) val++ ;
          
          sum += val - num ; 
          
          max = Math.max(max,sum);
        }
        
        
      }
      
      return max ; 
    }
}