class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return helper(0, 0, grid, m, n);
    }

    private int helper(int row, int col, int[][] grid, int m, int n) {
        if (row == m - 1 && col == n - 1) return grid[row][col]; // destination, just its own cost

        if (row == m - 1) return grid[row][col] + helper(row, col + 1, grid, m, n); // last row: forced right
        if (col == n - 1) return grid[row][col] + helper(row + 1, col, grid, m, n); // last col: forced down

        int right = helper(row, col + 1, grid, m, n);
        int down  = helper(row + 1, col, grid, m, n);
        return grid[row][col] + Math.min(right, down);
    }
}

// Complexity: O(2^(m+n)) time, O(m+n) space (recursion stack).

// Why it's slow: same story as before — helper(row, col, ...) is 
// recomputed for every path that happens to pass through that cell, and there can be exponentially many such paths.

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][] memo = new Integer[m][n];
        return helper(0, 0, grid, m, n, memo);
    }

    private int helper(int row, int col, int[][] grid, int m, int n, Integer[][] memo) {
        if (row == m - 1 && col == n - 1) return grid[row][col];
        if (memo[row][col] != null) return memo[row][col];

        int result;
        if (row == m - 1) {
            result = grid[row][col] + helper(row, col + 1, grid, m, n, memo);
        } else if (col == n - 1) {
            result = grid[row][col] + helper(row + 1, col, grid, m, n, memo);
        } else {
            int right = helper(row, col + 1, grid, m, n, memo);
            int down  = helper(row + 1, col, grid, m, n, memo);
            result = grid[row][col] + Math.min(right, down);
        }
        return memo[row][col] = result;
    }
}

// Complexity: O(m·n) time, O(m·n) space for memo + O(m+n) recursion stack.


class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];       // first row: only from left
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];       // first column: only from top
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

// tabulation : Complexity: O(m·n) time, O(m·n) space.

// 3. Tabulation — Bottom-Up DP

// dp[i][j] = minimum cost to reach cell (i, j) from (0, 0). First row/column can only be reached by accumulating along a straight line;
//  every other cell takes the cheaper of "from top" or "from left".