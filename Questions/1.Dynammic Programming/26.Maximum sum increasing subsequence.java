 

class Solution{
   
    
    public static void main(String[] args) throw Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int []arr = new int[n];
        int []dp = new int[n];
        Integer omax = Integer.MIN_VAUE;
        for(int i=0;i<n;i++){
            Integer max = null;
            
            for(int j=0;j<i;j++){
                if(arr[j] <= arr[i]){
                    if(max == null){
                        dp[j] = max;
                    }
                    
                    else (dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            
            if(max == null) dp[i] = max;
            
            else {
                dp[i] = max + arr[i];
            }
            
            if(dp[i] > omax) omax = dp[i];
        }
        
        return omax;
    }
}
    