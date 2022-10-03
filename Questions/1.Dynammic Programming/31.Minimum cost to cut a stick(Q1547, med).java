// Approach 1 :
Recursion 

class Solution {
    
    public int f(int i, int j, List<Integer>rod_Cuts){
        if(i > j) return 0;
        
        int mini = Integer.MAX_VALUE;
        
        for(int idx = i; idx <= j; idx++){
            int cost = rod_Cuts.get(j+1)  - rod_Cuts.get(i-1) 
                + f(i,idx-1,rod_Cuts) + f(idx+1,j,rod_Cuts); 
            
            mini = Math.min(mini,cost);
        }
        
        return mini;
    }
    public int minCost(int n, int[] cuts) {
        List<Integer> rod_Cuts = new ArrayList<>();
        
        rod_Cuts.add(0);
        for(int num : cuts){
            rod_Cuts.add(num);
        }
        rod_Cuts.add(n);
        
        Collections.sort(rod_Cuts);
        
        return f(1,cuts.length,rod_Cuts);
        
    }
}

// Approach 2 :
 memo 
class Solution {
    
    public int f(int i, int j, List<Integer>rod_Cuts,int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int idx = i; idx <= j; idx++){
            int cost = rod_Cuts.get(j+1)  - rod_Cuts.get(i-1) 
                + f(i,idx-1,rod_Cuts,dp) + f(idx+1,j,rod_Cuts,dp);   
            mini = Math.min(mini,cost);
        }
        return dp[i][j] = mini;
    }
    
    public int minCost(int n, int[] cuts) {
        List<Integer> rod_Cuts = new ArrayList<>();    
        rod_Cuts.add(0);
        for(int num : cuts){
            rod_Cuts.add(num);
        }
        rod_Cuts.add(n);
        Collections.sort(rod_Cuts);
        int cut_Len = cuts.length;
        int [][] dp = new int[cut_Len+1][cut_Len+1];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        return f(1,cuts.length,rod_Cuts,dp);
    }
}

// TC : O(c^2 * c) == O(c**3)

// SC : O(c**2) 



// Approach 3 : Tabulation 
class Solution {
    
 
    
    public int minCost(int n, int[] cuts) {
        List<Integer> rod_Cuts = new ArrayList<>();    
        rod_Cuts.add(0);
        for(int num : cuts){
            rod_Cuts.add(num);
        }
        rod_Cuts.add(n);
        Collections.sort(rod_Cuts);
        int cut_Len = cuts.length;
        int [][] dp = new int[cut_Len+2][cut_Len+2];
        for(int i=cut_Len; i>=1; i--){
            for(int j=1; j<= cut_Len; j++){
                if(i>j) continue;
                int mini = Integer.MAX_VALUE;
                for(int idx =i; idx<=j; idx++){
                    int cost = rod_Cuts.get(j+1) - rod_Cuts.get(i-1) 
                        + dp[i][idx-1] + dp[idx+1][j];
                    
                    if(mini > cost) mini = cost;
                }
                dp[i][j] = mini;
            }
        }
        
        return dp[1][cut_Len];
    }
}