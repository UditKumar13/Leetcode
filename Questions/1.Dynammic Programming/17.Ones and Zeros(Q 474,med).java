
// recursion solution 
// but this will give TLE for large inputs
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return helper(strs, m, n, 0);
    }

    int helper(String[] strs, int zero, int one, int index) {
        if (index == strs.length || (zero + one) == 0) {
            return 0;
        }

        int[] count = count(strs[index]);

        // Consider including the current string
        int consider = 0;
        if (zero >= count[0] && one >= count[1]) {
            consider = 1 + helper(strs, zero - count[0], one - count[1], index + 1);
        }

        // Skip the current string
        int skip = helper(strs, zero, one, index + 1);

        return Math.max(consider, skip);
    }

    int[] count(String s) {
        int[] count = new int[2];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}

// memo 3d array 
class Solution {
    int [][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m + 1][n + 1][strs.length];
        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        return helper(strs, m, n, 0);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        return helper(strs, m, n, 0);
    }

    int helper(String[] strs, int zero, int one, int index) {
        if (index == strs.length || (zero + one) == 0) {
            return 0;
        }
        if(dp[zero][one][index] != -1) {
            return dp[zero][one][index];
        }
        int[] count = count(strs[index]);

        // Consider including the current string
        int consider = 0;
        if (zero >= count[0] && one >= count[1]) {
            consider = 1 + helper(strs, zero - count[0], one - count[1], index + 1);
        }

        // Skip the current string
        int skip = helper(strs, zero, one, index + 1);

        return dp[zero][one][index] = Math.max(consider, skip);
    }

    int[] count(String s) {
        int[] count = new int[2];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}


// tabulation solution

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int [m+1][n+1];
        
        
        for(String s : strs){
            int []count = count(s);
            for(int zero =m;zero>=count[0];zero--){
                for(int one =n;one>= count[1];one--){
                    dp[zero][one] = Math.max(dp[zero - count[0]][one - count[1]] + 1, dp[zero][one]);
                }
            }
        
        }
        return dp[m][n];
    }
    
    public int[] count(String s){
        int [] count = new int[2];
        for(char ch : s.toCharArray()){
            count[ch - '0']++;
        }
        return count;
    }
}