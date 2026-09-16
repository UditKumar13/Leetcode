class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        return helper(0, 0, dungeon, m, n);
    }

    private int helper(int row, int col, int[][] dungeon, int m, int n) {
        if (row == m - 1 && col == n - 1) {
            // last cell: need enough health to survive just this cell's damage, minimum 1
            return Math.max(1, 1 - dungeon[row][col]);
        }
        if (row >= m || col >= n) return Integer.MAX_VALUE; // invalid path, never choose it

        int right = helper(row, col + 1, dungeon, m, n);
        int down  = helper(row + 1, col, dungeon, m, n);
        int needFromNext = Math.min(right, down); // pick the cheaper direction

        // health needed entering THIS cell = (health needed AFTER this cell) - (this cell's value), floored at 1
        return Math.max(1, needFromNext - dungeon[row][col]);
    }
}

/*

Complexity: O(2^(m+n)) time, O(m+n) space. 
Same overlapping-subproblem story as every grid DP so far — helper(row, col) recomputed across many paths.
 */

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        Integer[][] memo = new Integer[m][n];
        return helper(0, 0, dungeon, m, n, memo);
    }

    private int helper(int row, int col, int[][] dungeon, int m, int n, Integer[][] memo) {
        if (row >= m || col >= n) return Integer.MAX_VALUE;
        if (row == m - 1 && col == n - 1) {
            return Math.max(1, 1 - dungeon[row][col]);
        }
        if (memo[row][col] != null) return memo[row][col];

        int right = helper(row, col + 1, dungeon, m, n, memo);
        int down  = helper(row + 1, col, dungeon, m, n, memo);
        int needFromNext = Math.min(right, down);

        return memo[row][col] = Math.max(1, needFromNext - dungeon[row][col]);
    }
}

/*
memo : 
Complexity: O(m·n) time, O(m·n) space for memo + O(m+n) recursion stack.
*/


/*
3. Tabulation — Bottom-Up DP

Fill dp[i][j] starting from the bottom-right corner, moving backward — this is the natural iteration order
 once you accept the recursion goes "from the end."

dp[i][j] = minimum health needed entering cell (i, j). Use a grid of size (m+1) x (n+1) with an 
extra row/column of "sentinel" Integer.MAX_VALUE values so the boundary (last row / last column)
 doesn't need special-casing — except the two cells feeding into the true destination, which need
  value 1 instead of MAX_VALUE (to avoid overflow when subtracting).
*/

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];

        // Sentinel row/col: represents "off the grid", so min() never picks it
        // EXCEPT the two cells adjacent to the true destination, which need 1.
        for (int i = 0; i <= m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int needFromNext = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, needFromNext - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}