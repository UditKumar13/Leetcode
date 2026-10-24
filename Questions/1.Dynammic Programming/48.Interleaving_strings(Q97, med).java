class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return helper(s1, s2, s3, 0, 0);
    }

    private boolean helper(String s1, String s2, String s3, int i, int j) {
        if (i == s1.length() && j == s2.length()) return true; // consumed everything

        int k = i + j; // position in s3 is determined by i and j

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if (helper(s1, s2, s3, i + 1, j)) return true; // take next char from s1
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if (helper(s1, s2, s3, i, j + 1)) return true; // take next char from s2
        }
        return false;
    }
}

// Complexity: O(2^(m+n)) time in the worst case, O(m+n) recursion depth.

// Why it's slow: helper(i, j) is reached via many different interleaving prefixes 
// (e.g. "s1 then s2" and "s2 then s1" both land on the same (i, j)). Same subproblem, recomputed.


// 2. Memoization: Top-Down DP

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        Boolean[][] memo = new Boolean[m + 1][n + 1];
        return helper(s1, s2, s3, 0, 0, memo);
    }

    private boolean helper(String s1, String s2, String s3, int i, int j, Boolean[][] memo) {
        if (i == s1.length() && j == s2.length()) return true;
        if (memo[i][j] != null) return memo[i][j];

        int k = i + j;
        boolean result = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = helper(s1, s2, s3, i + 1, j, memo);
        }
        if (!result && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = helper(s1, s2, s3, i, j + 1, memo);
        }
        return memo[i][j] = result;
    }
}

// memo :
// Complexity: O(m · n) time, O(m · n) space for memo + O(m+n) recursion stack.

// tabulataion: Bottom-Up DP

// dp[i][j] = true if s3[0..i+j) is an interleaving of s1[0..i) and s2[0..j). A cell is true if the last
//      character of s3[0..i+j)
//      can come from s1[i-1] (with dp[i-1][j] true) or from s2[j-1] (with dp[i][j-1] true).

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // empty + empty = empty

        // first column: using only s1
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        // first row: using only s2
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = s3.charAt(i + j - 1);
                boolean fromS1 = dp[i - 1][j] && s1.charAt(i - 1) == c;
                boolean fromS2 = dp[i][j - 1] && s2.charAt(j - 1) == c;
                dp[i][j] = fromS1 || fromS2;
            }
        }
        return dp[m][n];
    }
}


Complexity: O(m · n) time, O(m · n) space.

// Connection to Phase 2: this table is really a grid-path problem. Moving down means 
// "take a char from s1", moving right means "take a char from s2", and a move is only allowed
//  if the character matches s3[i+j-1]. You're asking: is there a valid path from (0,0) to (m,n)? 
//  That's Unique Paths II with a matching-based obstacle rule, and boolean OR instead of sum. If you say
//  this out loud in an interview, it shows you see the pattern across problems.

