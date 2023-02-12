class Solution {
    public int findJudge(int n, int[][] trust) {
        int []check = new int[n+1];
        
        // frequency trick will work here 
        for(int []arr : trust){
            check[arr[0]]--;
            check[arr[1]]++;
        }
        for(int i=1;i<=n;i++){
            if(check[i] == n-1) return i;
        }
        return -1;
    }
}
