class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // at each end you have two choices
        // left or right most card
        // for k = 1 max is 1
        // for k = 2, max is 7, (1,1), (1,6), (1,2)
        int sumf = 0;
        int sumb = 0;
        
        for(int i = 0; i < k; i++){
            sumf += cardPoints[i];
        }
        
        int max = sumf;

        for(int i = k-1; i >= 0; i--){
            sumf -= cardPoints[i];
            sumb += cardPoints[cardPoints.length-(k-i)];
            
            int tmp = sumf + sumb;
            max = Math.max(tmp, max);
        }
        
        return max;
        

    }
}