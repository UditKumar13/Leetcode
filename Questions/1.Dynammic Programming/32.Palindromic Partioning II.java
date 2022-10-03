class Solution {
    public int minCut(String s) {
        boolean [][]dp = new boolean[s.length()][s.length()];
        for(int g=0;g<s.length();g++){
            for(int i=0, j=g;j<dp.length;i++,j++){
                if(g==0){
                   dp[i][j] = true;
                }else if(g==1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        int []storeCuts = new int[s.length()];
        storeCuts[0] = 0;
        
        for(int j=1;j<storeCuts.length;j++){
            if(dp[0][j]) {
                storeCuts[j] = 0;
            }
            
            else{
                 int mini = Integer.MAX_VALUE;
            for(int i=j; i>=1; i--){
                if(dp[i][j]){
                    mini = Math.min(mini,storeCuts[i-1]);
                }
            }
            storeCuts[j] = mini + 1;
        }
            }
           
        
        return storeCuts[s.length()-1];
    } 
}

// TC : O(n**2)