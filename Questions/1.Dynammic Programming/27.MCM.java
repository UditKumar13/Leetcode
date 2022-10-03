class Solution{
    
    public int matrixMultiplication(int []arr, int N){
        int [][]dp = new int[N][N];
        
        
        for(int i=0;i<N;i++)dp[i][i] = 0;
        
        // bottom up 
        for(int i=N-1; i>=0; i--){
            for(int j=i+1;j<N;j++){
                int mini = Integer.MAX_VALUE;
                
                for(int k= i;k<j;k++){
                    int steps = arr[i-1] * arr[k] * arr[j];
                     + dp[i][k] + dp[k+1][j];
                    
                    if(steps < mini) mini = steps;
                }
                
                dp[i][j] = mini;
            }
        }
        
        return dp[1][N-1];
    }
}