
// A very good example of a Binary Search apliation 

class Solution {
  
  
   public boolean canEatinTime(int [] arr , int mid , int h){
     
     
     int sum = 0 ; 
     
     for (int val : arr){
       int div = val / mid ; 
       
       sum += div ; 
       
       if(val % mid !=0 )sum++ ; 
     }
     
     if (sum <= h ){
       return true ; 
     }
     
     return false ; 
   }
  
    public int minEatingSpeed(int[] arr, int h) {
      
      // we have to use the binary search  here 
      // O(nlogm)
      int low  = 1 ; 
      int high = 1000000000 ; 
      
      int mid = 0 ; 
      while(low <= high){
        mid = (low+high)/2 ;
       
        if(canEatinTime(arr,mid,h)) {
          high = mid -1 ; 
        }
        
        else {
          low = mid + 1 ; 
        }
      }
      
      
      return low; 
    }
}