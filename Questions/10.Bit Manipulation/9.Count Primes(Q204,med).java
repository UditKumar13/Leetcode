class Solution {
    public int countPrimes(int n) {
        boolean [] remove = new boolean[n+1];
        if(n == 0 || n ==1) return  0;
        
        for(int div = 2;div*div<n;div++){
            if(!remove[div]){
                for(int i=2*div;i<=n;i+=div){
                    remove[i] = true;
                }
            }
        }
        
        int count = 0;
        for(int i=2;i<n;i++){
            if(!remove[i]) count++;
        }
        return count;
    }
}