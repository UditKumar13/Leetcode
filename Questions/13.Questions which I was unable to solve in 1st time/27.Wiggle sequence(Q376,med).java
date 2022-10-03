class Solution {
    public int bottomUp(int []diff){
        int n=diff.length;
        int [][] dp = new int[n+1][2];
        for(int []row:dp){
            Arrays.fill(row,0);
        }
        for(int i=n-1;i>=0;i--){
            for(int pos=0;pos<2;pos++){
                if(pos == 1){
                    if(diff[i]>0){
                        dp[i][pos] = Math.max(1+dp[i+1][0],dp[i+1][pos]);
                    }else{
                    dp[i][pos] = dp[i+1][pos];
                }
            }else{
                if(diff[i]<0){
                    dp[i][pos] =Math.max(1+dp[i+1][1],dp[i+1][pos]); 
                }else{
                    dp[i][pos] = dp[i+1][pos];
                }
            }
        }
        }
        return Math.max(dp[0][0],dp[0][1]);
    }
        
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if(len == 1 || len == 0) return len;
        int []diff = new int[len-1];
        for(int i=1;i<=len-1;i++){
            diff[i-1] = nums[i] - nums[i-1];
        }
        int ans = bottomUp(diff);
        return ans+1;
    }
}

// Recursive Solution just similar to stock and sell 


// Approach 2 :

class Solution {

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if(len == 0) return len;
        
        int []up = new int[len];
        int []down = new int[len];
        up[0] = 1;
        down[0] = 1;
        
        for(int i=1;i<=len-1;i++){
            if(nums[i] < nums[i-1]){
                // this denotes curr ele is less than prev ele, going down,
                // so for maintaining the alternate max sequence 
                // I have to add  1 more in the prev up[i-1] that will give me the curr down[i]
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }else if(nums[i] > nums[i-1]){
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }else{
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        
        return Math.max(up[up.length-1],down[down.length-1]);
    }
}



// beat 100 % of java solution 
