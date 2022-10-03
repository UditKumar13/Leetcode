class Solution {
    
  
    public int maximumWhiteTiles(int[][] tiles, int cl) {
        
        Arrays.sort(tiles,(a,b) -> a[0] - b[0]); // sort in the decreasing order
        int right = 0, n = tiles.length, ans = 0,currTotal = 0;
        
        for(int i=0;i<n;i++){
            int start = tiles[i][0], end = start + cl -1;
            while (right < n && tiles[right][1] < end){
                currTotal +=tiles[right][1]  - tiles[right][0] + 1 ;
                right++;
            }
            
            if (right == n || tiles[right][0] > end){
                ans = Math.max(ans,currTotal);
            }
            
            else {
                ans = Math.max(ans,currTotal + end - tiles[right][0] + 1);
            }
            
            currTotal -= tiles[i][1] - tiles[i][0] + 1;
        }
        return ans;
    }
}

TC : O(nlogn)
SC : O(1)