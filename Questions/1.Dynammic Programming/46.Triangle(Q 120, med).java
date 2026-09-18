class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(0, 0, triangle);
    }

    private int helper(int row, int col, List<List<Integer>> triangle) {
        if (row == triangle.size() - 1) return triangle.get(row).get(col); // last row: base case

        int down      = helper(row + 1, col, triangle);     // directly below
        int downRight = helper(row + 1, col + 1, triangle); // diagonally right
        return triangle.get(row).get(col) + Math.min(down, downRight);
    }
}

// Complexity: O(2^n) time (n = number of rows) — each cell branches into two calls,
//  O(n) recursion depth.

// Why it's slow: helper(row, col) gets called repeatedly for the same (row, col)
//  from different paths above it — classic overlapping subproblems.


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n];
        return helper(0, 0, triangle, memo);
    }

    private int helper(int row, int col, List<List<Integer>> triangle, Integer[][] memo) {
        if (row == triangle.size() - 1) return triangle.get(row).get(col);
        if (memo[row][col] != null) return memo[row][col];

        int down      = helper(row + 1, col, triangle, memo);
        int downRight = helper(row + 1, col + 1, triangle, memo);
        return memo[row][col] = triangle.get(row).get(col) + Math.min(down, downRight);
    }
}

// 2. Memoization — Top-Down DP
// Complexity: O(n²) time (n² total cells in the triangle, each computed once),
//  O(n²) space for memo + O(n) recursion stack.

// 3. Tabulation — Bottom-Up DP

// The natural direction here is literally bottom-up — start from the last 
// row (already the answer for each of its cells) and collapse upward.


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // last row: dp value is just the triangle value itself
        for (int col = 0; col < n; col++) {
            dp[n - 1][col] = triangle.get(n - 1).get(col);
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int down      = dp[row + 1][col];
                int downRight = dp[row + 1][col + 1];
                dp[row][col] = triangle.get(row).get(col) + Math.min(down, downRight);
            }
        }
        return dp[0][0];
    }
}

