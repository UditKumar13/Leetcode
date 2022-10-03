
/*
https://leetcode.com/problems/powx-n/discuss/1515322/Java-or-TC%3A-O(logN)-or-Optimized-Recursive-and-Iterative-(handles-overflow)-solutions
*/
class Solution {
  
  double myPow(double x, int n) { 
   
    if (n==0) return 1 ; 
    
    if(n == 1 || x == 1 || x == 0) return x ; 
    
    else if(n < 0 ){
      return 1/x * myPow(1/x, -(n+1)) ;
    }
    
    return n%2==0 ? myPow(x*x,n/2 ): x * myPow(x*x,n/2) ;  
  }
}