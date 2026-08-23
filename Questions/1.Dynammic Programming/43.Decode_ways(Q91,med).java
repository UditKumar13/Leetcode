class Solution {
    public int numDecodings(String s) {
        return helper(s, 0);
    }
    // returns number of ways to decode s[i:]
    private int helper(String s, int i) {
        if (i == s.length()) return 1; // reached the end cleanly — one valid way
        if (s.charAt(i) == '0') return 0; // can't start with '0'
        
        int ways = helper(s, i + 1); // take 1 digit
        
        if (i + 1 < s.length()) {
            int twoDigit = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (twoDigit <= 26) {
                ways += helper(s, i + 2); // take 2 digits
            }
        }
        return ways;
    }
}

// Brute Force (Recursion, no memo) — O(2ⁿ) time

/*
in go : 
func numDecodings(s string) int {
    return helper(s, 0)
}
func helper(s string, i int) int {
    if i == len(s) {
        return 1
    }
    if s[i] == '0' {
        return 0
    }
    ways := helper(s, i+1)
    if i+1 < len(s) {
        twoDigit := int(s[i]-'0')*10 + int(s[i+1]-'0')
        if twoDigit <= 26 {
            ways += helper(s, i+2)
        }
    }
    return ways
}
*/


// top down approach using dp (memoization)
class Solution {
    private Integer[] memo; 
    public int numDecodings(String s) {
        memo = new Integer[s.length()+1];
        return helper(s, 0);
    }

    public int helper(String s, int i){
        // base case 
        if (i == s.length()) return 1; // reached end cleanly - one valid way
        if (s.charAt(i) == '0') return 0; // can't start with '0'

        if (memo[i] != null) return memo[i];

        int ways = helper(s, i+1); // take 1 digit 

        if (i+1 < s.length()){
            int twoDigits = (s.charAt(i)-'0') * 10 + (s.charAt(i+1)-'0');
            if (twoDigits <= 26){
                ways += helper(s, i+2); // take 2 digits
            }
        }
        memo[i] = ways; 
        return ways;


    }
}

// Time: O(n) | Space: O(n) (for the memoization array)

/*
in go : 
func numDecodings(s string) int {
    memo := make([]int, len(s)+1)
    for i := range memo {
        memo[i] = -1
    }
    return helper(s, 0, memo)
}
func helper(s string, i int, memo []int) int {
    if i == len(s) {
        return 1
    }
    if s[i] == '0' {
        return 0
    }
    if memo[i] != -1 {
        return memo[i]
    }
    ways := helper(s, i+1, memo)
    if i+1 < len(s) {
        twoDigit := int(s[i]-'0')*10 + int(s[i+1]-'0')
        if twoDigit <= 26 {
            ways += helper(s, i+2, memo)
        }
    }
    memo[i] = ways
    return ways
}

*/

// optimal bottom up approach (tabulation)

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;
        
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty prefix — 1 way (decode nothing)
        dp[1] = 1; // first char is guaranteed non-'0' by the check above
        
        for (int i = 2; i <= n; i++) {
            // 1-digit check: s[i-1] (0-indexed) must not be '0'
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // 2-digit check: s[i-2..i-1] must be in [10, 26]
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}

// Bottom-Up (standard array version) — O(n) time, O(n) space

// Here dp[i] = number of ways to decode s[0..i-1] (the first i characters). 
// This shift (using length-so-far instead of index-into-string) is common in string DP
//  — makes the dp[0] = 1 base case cleaner.


/*
in go : 

*/


// most optimal bottom up approach (space optimized)


class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;
        
        int prev2 = 1; // dp[0]
        int prev1 = 1; // dp[1]
        
        for (int i = 2; i <= n; i++) {
            int curr = 0;
            if (s.charAt(i - 1) != '0') {
                curr += prev1;
            }
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += prev2;
            }
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}

// Optimal (rolling variables) — O(n) time, O(1) space

// Same as Climbing Stairs/House Robber — only dp[i-1] and dp[i-2] ever matter, 
// so roll them forward.