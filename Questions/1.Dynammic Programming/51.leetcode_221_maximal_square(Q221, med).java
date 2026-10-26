// memo 

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Integer[][] memo = new Integer[m][n];
        int maxSide = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxSide = Math.max(maxSide, helper(matrix, i, j, memo));
            }
        }
        return maxSide * maxSide;
    }

    private int helper(char[][] matrix, int i, int j, Integer[][] memo) {
        if (i < 0 || j < 0 || matrix[i][j] == '0') return 0;
        if (memo[i][j] != null) return memo[i][j];

        int top      = helper(matrix, i - 1, j, memo);
        int left     = helper(matrix, i, j - 1, memo);
        int topLeft  = helper(matrix, i - 1, j - 1, memo);

        return memo[i][j] = 1 + Math.min(top, Math.min(left, topLeft));
    }
}

// Complexity: O(m·n) time, O(m·n) space for memo + O(m+n) recursion stack.
