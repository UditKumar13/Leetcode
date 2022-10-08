class Solution {
    Map <String,Integer> map = new HashMap<>();
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        if(target > n*k || target <n) return 0;
        if(n==1) return (target <= k) ? 1: 0;
        
        final String key = "" + n + k + target;
        if(!map.containsKey(key)){
            int sum = 0;
            for(int i=k;i>0;--i){
                sum += numRollsToTarget(n-1,k,target-i);
                sum %= mod;
            }
            map.put(key,sum);
        }
        return map.get(key);
        
    }
    
    
}