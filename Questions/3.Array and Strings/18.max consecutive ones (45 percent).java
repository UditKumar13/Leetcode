class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        
      
    int max = 0 , count = 0 , ans = 0 ; 
    boolean des = false ; 
    if(arr.length ==1 && arr[0] == 0) return 0 ;
    if(arr.length ==1 && arr[0] == 1) return 1;
    
    
    for(int i = 0 ; i< arr.length ; i++){
      count = 0 ; 
      if(arr[i] == 1){
        ans = 1 ; 
         
      }
      
      
     if(i>=1 && i<=arr.length-1){
       
       while(arr[i] == 1 && (arr[i] == arr[i-1])){
         count++ ; 
         i++ ; 
         if(i==arr.length ) break ;  
       }
       
       if(count > max){
         max = count  ;
       }
     }
      
      
    } // for ends here 
      
      if(ans == 0 && max == 0){
        return ans ; 
      }
    
      if (ans > max){
        ans = 1 ; 
      }
      
      
      else {
        ans = max + 1 ; 
      }
      
      
      
      return ans ; 
      
      
    }
    }