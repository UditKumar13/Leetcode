class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return helper(0, 0, grid, m, n);
    }

    private int helper(int row, int col, int[][] grid, int m, int n) {
        if (row >= m || col >= n || grid[row][col] == 1) return 0; // out of bounds or blocked
        if (row == m - 1 && col == n - 1) return 1;                 // reached destination

        int right = helper(row, col + 1, grid, m, n);
        int down  = helper(row + 1, col, grid, m, n);
        return right + down;
    }
}

// Complexity: O(2^(m+n)) time, O(m+n) space (recursion stack). Same exponential 
// blow-up as before, same overlapping-subproblem issue.

// 
// memoization (top-down DP) — O(m*n) time, O(m*n) space

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][] memo = new Integer[m][n];
        return helper(0, 0, grid, m, n, memo);
    }

    private int helper(int row, int col, int[][] grid, int m, int n, Integer[][] memo) {
        if (row >= m || col >= n || grid[row][col] == 1) return 0;
        if (row == m - 1 && col == n - 1) return 1;
        if (memo[row][col] != null) return memo[row][col];

        int right = helper(row, col + 1, grid, m, n, memo);
        int down  = helper(row + 1, col, grid, m, n, memo);
        return memo[row][col] = right + down;
    }
}

// 3. Tabulation — Bottom-Up DP 

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0; // obstacle: no paths through here
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1; // start cell
                } else {
                    int fromTop  = (i > 0) ? dp[i - 1][j] : 0;
                    int fromLeft = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = fromTop + fromLeft;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
