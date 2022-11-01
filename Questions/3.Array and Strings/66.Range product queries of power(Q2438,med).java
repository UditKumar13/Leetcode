class Solution {
    public int[] productQueries(int n, int[][] q) {
        
       int mod = 1000000007;
        List <Integer> powers = new ArrayList<Integer>();
        // for making the powers from a integer 
        int m = 0;
        
        while(n>0){
            int bit = (int)(n%2);
            if(bit==1){
                powers.add((int)Math.pow(2,m));
            }
            m++;
            n /= 2;
        }
        int []arr = new int[q.length];
        int j = 0;
        for(int[] que : q){
            long res = 1;
            for(int i=que[0]; i<=que[1];i++){
                res = (res*powers.get(i)%mod);
            }
            arr[j++] = (int)(res)%mod;
        }
        return arr;
    
        
    }
}