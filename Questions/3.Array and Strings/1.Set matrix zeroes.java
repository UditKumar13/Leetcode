class Solution {
    public int [][] setZeroes(int[][] arr) {
      
      boolean fr = false ; 
      boolean fc =false ; // to keep track of the first ele itself
      // we are using the first ele of each of row and col to track 
      
      
      // marking 
      for (int i = 0; i<arr.length ; i++){
        for(int j=0;j<arr[0].length ; j++){
          if (arr[i][j] == 0 ){
            
            
            arr[i][0] = 0 ;
            arr[0][j] = 0 ;
            
            if(i==0) fr = true  ;
            
            if(j==0) fc = true ; 
            
            
          }
        }
      }
      
      
      
      // altering the inner small 2d array start with i =1 , j =1
      // leaving the outer first row and first col 
      for(int i = 1; i<arr.length ; i++){
        for(int j =1 ; j<arr[0].length; j++){
          
          
          if(arr[i][0] == 0 || arr[0][j] == 0){
            arr[i][j] = 0 ; 
          }
        }
      }
      
      
      // have to alter if the ele belongs to first col or row
      
      if (fr){
        for(int j=0; j<arr[0].length ; j++){
          arr[0][j] = 0 ; 
        }
      }
      
      if(fc){
        for(int i=0 ; i<arr.length ; i++){
          arr[i][0] = 0 ; 
        }
      }
       return arr ; 
    }
 
}