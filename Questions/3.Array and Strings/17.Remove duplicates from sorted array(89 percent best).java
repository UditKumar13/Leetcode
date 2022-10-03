class Solution {
    public int removeDuplicates(int[] arr) {
        
      
      if(arr.length == 0 || arr == null ) return 0  ;
      int curr  =  arr[0] ; 
      
      int count = 0; 
      
      
      for(int i =1 ; i< arr.length ; i++){
        
        if(curr != arr[i]){
         curr = arr[i] ;
          count ++ ; 
          arr[count] = curr ;
        }
        
        
      }
      
      return count+1 ; 
    }
  
}