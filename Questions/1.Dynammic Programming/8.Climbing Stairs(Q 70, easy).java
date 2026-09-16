class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

// Time: O(2^n) | Space: O(n) (for the recursion stack)

// brute force solution using recursion
/*
brute force solution in golang


func climbStairs(n int) int {
    if n <= 1 {
        return 1
    }
    return climbStairs(n-1) + climbStairs(n-2)
}
*/


class Solution {
    public int climbStairs(int n){
        
        int  [] dp = new int [n+1];
        
        if (n == 0 || n==1) return n;
 
        dp[1] = 1;
        dp[2] = 2;
        for(int i =3; i<=n; i++){
            dp[i]  = dp[i-1] + dp[i-2]  ; 
        }
        
        return dp[n] ; 
        
        
    }
}

// better 
// Time: O(n) | Space: O(n) (for the dp array)

// best solution 
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int prev2 = 1; // ways(0)
        int prev1 = 1; // ways(1)
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

// Time: O(n) | Space: O(1) (constant space)

