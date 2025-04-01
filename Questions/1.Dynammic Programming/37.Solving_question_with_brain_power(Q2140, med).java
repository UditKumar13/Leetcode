//https://leetcode.com/problems/solving-questions-with-brainpower/solutions/6602513/dp-approach-visualization-math-python-c-java/?envType=daily-question&envId=2025-04-01

class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        for(int i = questions.length-1; i >= 0; i--){
            int nextIndex = i + questions[i][1] + 1;
            if(nextIndex < questions.length){
                dp[i] = dp[nextIndex] + questions[i][0];
            }else{
                dp[i] = questions[i][0];
            }
            if(i < questions.length-1){
                dp[i] = Math.max(dp[i+1], dp[i]);
            }
        }
        return dp[0];
    }
}