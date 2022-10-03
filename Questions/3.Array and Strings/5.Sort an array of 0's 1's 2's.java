
// Took 10 min
// This variation is called Dutch National Flag algorithm
class Solution {
  public void swap (int i , int j, int [] arr){
    
    int temp = arr[i];
    
    arr[i] = arr[j] ;
    
    arr[j] = temp ; 
    
  }
  
    public void sortColors(int[] arr) {
        
      
      int  i=0, j = 0 ;
      
      int k = arr.length -1 ; 
      
      while(i<=k){
        
        if (arr[i] == 1){
          i++ ; 
          // when 1 come simply ignore
        }
        
        
        else if(arr[i] == 0){
          swap(i,j,arr);
          i++;
          j++;
          
          // 0 will tackle with the 1 only 
        }
        
        
        else {
          // that means that ele is 2 
          swap(i,k,arr);
          k-- ; 
          // only k will decrement
        }
      }
      
      
    }
}