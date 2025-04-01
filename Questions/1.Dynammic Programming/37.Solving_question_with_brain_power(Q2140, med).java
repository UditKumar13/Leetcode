//https://leetcode.com/problems/solving-questions-with-brainpower/solutions/6602513/dp-approach-visualization-math-python-c-java/?envType=daily-question&envId=2025-04-01

class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        for(int i = questions.length-1; i >= 0; i--){
            int nextIndex = i + questions[i][1] + 1; // nextIndex is the index of the next question that can be solved after solving the current question
            if(nextIndex < questions.length){
                dp[i] = dp[nextIndex] + questions[i][0]; // if there are more questions to solve, take the maximum of the current question's points and the next question's points
            }else{
                dp[i] = questions[i][0]; // if there are no more questions to solve, just take the points from the current question
            }
            if(i < questions.length-1){
                dp[i] = Math.max(dp[i+1], dp[i]); // take the maximum of the current question's points and the next question's points
            }
        }
        return dp[0]; // max result is stored in dp[0].
    }
}