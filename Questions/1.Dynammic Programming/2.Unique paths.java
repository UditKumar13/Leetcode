class Solution {
  
 
    public int uniquePaths(int m, int n) {
        
     // we will not use factorial 
    // the ans is (m+n-2)! / (m-1) ! * (n-1)!
      // number of paths 
      
      if(m==1 || n==1){
        return 1 ;
      }
      
      m--;
      n--;
      
      // let us make the m bigger 
  
      if (m<n){
        // swap m and  n 
        m = m + n ;
        n = m - n ; 
        m = m - n ; 
        
      }
      
      
      // instead of using the factorial we will be using a simple for loop
      long res = 1  ;; 
      for(int i = m+1, j =1 ; i<= m + n ; i++,j++){
        res *= i;
        res /= j; 
      }
      
      return (int)res ; 
      
    }
}