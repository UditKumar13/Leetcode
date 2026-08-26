class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return helper(s, 0, dict);
    }
    // can s[i:] be fully segmented into dictionary words?
    private boolean helper(String s, int i, Set<String> dict) {
        if (i == s.length()) return true;
        
        for (int j = i + 1; j <= s.length(); j++) {
            String word = s.substring(i, j);
            if (dict.contains(word) && helper(s, j, dict)) {
                return true;
            }
        }
        return false;
    }
}

// Brute Force (Recursion, no memo) — O(2ⁿ) time

/*
func wordBreak(s string, wordDict []string) bool {
    dict := make(map[string]bool)
    for _, w := range wordDict {
        dict[w] = true
    }
    return helper(s, 0, dict)
}
func helper(s string, i int, dict map[string]bool) bool {
    if i == len(s) {
        return true
    }
    for j := i + 1; j <= len(s); j++ {
        word := s[i:j]
        if dict[word] && helper(s, j, dict) {
            return true
        }
    }
    return false
}
*/


// top down approach using dp (memoization)
class Solution {
    private Boolean[] memo;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        memo = new Boolean[s.length()];
        return helper(s, 0, dict);
    }
    private boolean helper(String s, int i, Set<String> dict) {
        if (i == s.length()) return true;
        if (memo[i] != null) return memo[i];
        
        for (int j = i + 1; j <= s.length(); j++) {
            String word = s.substring(i, j);
            if (dict.contains(word) && helper(s, j, dict)) {
                memo[i] = true;
                return true;
            }
        }
        memo[i] = false;
        return false;
    }
}

// Time: O(n²) | Space: O(n) (for the memoization array)


/*
func wordBreak(s string, wordDict []string) bool {
    dict := make(map[string]bool)
    for _, w := range wordDict {
        dict[w] = true
    }
    memo := make(map[int]bool)
    var helper func(i int) bool
    helper = func(i int) bool {
        if i == len(s) {
            return true
        }
        if v, ok := memo[i]; ok {
            return v
        }
        for j := i + 1; j <= len(s); j++ {
            word := s[i:j]
            if dict[word] && helper(j) {
                memo[i] = true
                return true
            }
        }
        memo[i] = false
        return false
    }
    return helper(0)
}
*/


// optimal 
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true; // base case: empty suffix is always "breakable"
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (dp[j] && dict.contains(s.substring(i, j))) {
                    dp[i] = true;
                    break; // found one valid split, no need to check more
                }
            }
        }
        return dp[0];
    }
}

// Optimal (Bottom-Up) — O(n²) time, O(n) space

// Fill dp[] from the end of the string backward (mirrors the recursion direction — dp[i]
//      depends on dp[j] where j > i), or equivalently, forward using "does this word ending
//       at i exist and was the start reachable."

// Backward version (mirrors top-down most directly):


/*
func wordBreak(s string, wordDict []string) bool {
    dict := make(map[string]bool)
    for _, w := range wordDict {
        dict[w] = true
    }
    n := len(s)
    dp := make([]bool, n+1)
    dp[n] = true
    
    for i := n - 1; i >= 0; i-- {
        for j := i + 1; j <= n; j++ {
            if dp[j] && dict[s[i:j]] {
                dp[i] = true
                break
            }
        }
    }
    return dp[0]
}
*/

