class Solution {
    public int subarraysDivByK(int[] A, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0,rem;i<A.length;i++){
            if(i>0) A[i] += A[i-1];
            rem = (A[i] % k + k) %k;
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        int res = map.getOrDefault(0,0);
        for(int n : map.values()){
            res += ((n) * (n-1))/2; // for the same remainder that means subarray k exist
        }
        return res;
    }
}