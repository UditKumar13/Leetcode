
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.



*/






class Solution {
  
    public boolean searchMatrix(int[][] arr, int num) {
      
      int i = 0;
      int j = arr[0].length-1;
      
      while(i<arr.length && j>=0){
        if(arr[i][j] == num){
          return true ; 
        }
        
        else if(arr[i][j] < num){
          // decreasing the row 
          i++ ; 
        }
        
        else {
          j-- ; 
          // check the other column in the same row 
        }
        
        
        
      }
      
      return false ; 
    }
}