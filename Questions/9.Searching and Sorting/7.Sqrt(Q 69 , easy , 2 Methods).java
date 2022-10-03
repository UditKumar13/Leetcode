
// Brute force 
TC : O(n)

Sc: O(1)
class Solution {
    public int mySqrt(int x) {
     
        int ans = 0 ; 
        for(int i =1 ; i<=x ; i++){
            int i2 = i*i ; 
            
            if (i2 == x){
                ans = i ; 
                break ; 
            }
             if ( i2 > x){
                ans = i-1 ; 
                 break ; 
            }
        }
     return ans ; 
    }   
}


// Binary search with this 
// TC O(logx)  // SC O(1)
class Solution {
       
public int mySqrt(int x) {
    if (x == 0)
        return 0;
    int left = 1, right = x;
    while (true) {
        int mid = left + (right - left)/2; // write this way 
        if (mid > x/mid) {
            right = mid - 1;  // modify the right 
        } else {
            if (mid + 1 > x/(mid + 1))
                return mid; // we are checking for one greater not exact 
                              // for 18 : 5 > 18/ 5    retrun 5 
            left = mid + 1;
        }
    }
}
  
}