/*

Complexity: O(2^(m+n)) time — classic exponential blow-up, O(m+n) recursion depth.

Why it's slow: helper(row, col, ...) is called repeatedly for the same (row, col) via different paths — massive overlap. Same state, recomputed over and over.*/



class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0, 0, m, n);
    }

    private int helper(int row, int col, int m, int n) {
        if (row == m - 1 && col == n - 1) return 1; // reached destination
        if (row >= m || col >= n) return 0;          // out of bounds

        int right = helper(row, col + 1, m, n);
        int down  = helper(row + 1, col, m, n);
        return right + down;
    }
}


// memoization (top-down DP) — O(m*n) time, O(m*n) space

class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];
        return helper(0, 0, m, n, memo);
    }

    private int helper(int row, int col, int m, int n, Integer[][] memo) {
        if (row == m - 1 && col == n - 1) return 1;
        if (row >= m || col >= n) return 0;
        if (memo[row][col] != null) return memo[row][col];

        int right = helper(row, col + 1, m, n, memo);
        int down  = helper(row + 1, col, m, n, memo);
        return memo[row][col] = right + down;
    }
}

// optimal 

// 3. Tabulation — Bottom-Up DP

// dp[i][j] = number of ways to reach cell (i, j).
//  First row and first column can only be reached one way (straight line), everything else is dp[i-1][j] + dp[i][j-1].
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1; // only one way along top row / left column
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}



// 
// 4. Space-Optimized — 1D Rolling Array

// Since dp[i][j] only depends on the row above and the current row,
//  you don't need the full 2D grid — one 1D array updated in place works.

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // first row: all 1s

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1]; // dp[j] (from above) + dp[j-1] (from left)
            }
        }
        return dp[n - 1];
    }
}