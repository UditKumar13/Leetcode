class Solution {
//     Approach 2: Recursion + Memoization (Top-Down DP)
// Explanation
// We cache the results of subproblems using a HashMap or 2D array. Once we calculate how much champagne is in a glass, we store it and reuse it.
// State: dp[row][glass] = amount of champagne in that glass


//Time Complexity: O(R²) where R = query_row

// Number of unique states: Each glass (row, glass) is calculated only once
// Total glasses in rows 0 to R: 1 + 2 + 3 + ... + (R+1) = (R+1)(R+2)/2 ≈ O(R²)
// Each state computation: O(1) after memoization
// Overall: O(R²)
// Space Complexity: O(R²)

// Memoization array: (R+1) × (R+1) = O(R²)
// Recursion call stack: O(R) in worst case (depth = R)
// Total: O(R²) + O(R) = O(R²)

    public double champagneTower(int poured, int query_row, int query_glass) {
        Double [][] memo = new Double[query_row + 1][query_row+1];
        // Capacity Limits: When simulating physical constraints (glass holds 1 cup):
        // Always cap the result: Math.min(1.0, amount)
        return Math.min(1.0, getAmount(poured, query_row, query_glass, memo));
    }

    public double getAmount(double poured, int row, int glass, Double [][]memo){
        // invalid position 
        if(glass < 0 || glass > row) return 0.0;

        // base 1st glass
        if(row == 0 && glass == 0) return poured;

        // check memo , if already have the ans
        if(memo[row][glass] != null) return memo[row][glass];
        double leftParentAmount = getAmount(poured, row - 1, glass -1, memo);
        double fromLeft = Math.max(0, (leftParentAmount - 1.0)/2.0);
        double rightParentAmount = getAmount(poured, row-1, glass, memo);
        double fromRight = Math.max(0, (rightParentAmount - 1.0)/2.0);
        memo[row][glass] = fromLeft + fromRight;
        return memo[row][glass];
    }

}