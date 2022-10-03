class Solution {
  
  // we have to write the 2 function  swap and reverse the array part
  
  
  
  public void swap(int i, int j, int [] arr ){
    int temp = arr[i];
    
    arr[i] = arr[j] ;
    
    arr[j] = temp ;
    
  }
  
  
  public void reverse(int st, int end, int [] arr){
    
    // 2 pointer approach 
    
    while(st < end){
      swap(st,end,arr);
      st++;
      end--;
    }
  }
  
  
    public int []  nextPermutation(int[] nums) {
      // base case 
      
      if ( nums.length <= 1){
        return nums ; // as it is 
      }
      
      int len = nums.length  ;
       
        // let us do this in O(n) Tc
      
      int i = nums.length - 2 ;
      
      // find the i th ele 
      
      while( i >= 0 && nums[i] >= nums[i+1]) i-- ; 
      
      if (i>=0){
        
        int j = nums.length-1 ; 
        
        // find the right position of j 
        
        while(nums[i] >= nums[j]) j-- ; 
        // swap the ith and the jth place 
        
        swap(i,j,nums) ; 
      }
      
      // reverse the i+1 to n-1 part of the array 
      
      reverse(i+1,nums.length-1, nums) ;
      
      return nums ; 
      
        
    }
}