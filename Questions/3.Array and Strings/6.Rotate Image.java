class Solution {
  
  public void transpose(int [][] arr){
    
    for (int i =0 ; i< arr.length ; i++){
      for(int j = i ; j< arr[0].length; j++){
        
        
        
      if (i != j){
     int temp = arr[i][j] ;
        
      arr[i][j] = arr[j][i] ;
        
      arr[j][i] = temp ;
      }

      }
    }
  }
  
  
  

  
    public void rotate(int[][] arr) {
        
      // this can be done by 2 steps 
      
      // step 1 : transpose 
      // step 2 : reverse each row 
      
      
      // transpose 
      
      transpose(arr);
     
      
      
       // reverse 
    for (int i =0 ; i< arr.length ; i++){
      for(int j = 0 ; j< arr.length/2; j++){
        
  
    int temp = arr[i][j];
    
    arr[i][j] = arr[i][arr.length-j-1] ;
    arr[i][arr.length-1-j] = temp ; 
      
      }
    }
      
      
    }
}