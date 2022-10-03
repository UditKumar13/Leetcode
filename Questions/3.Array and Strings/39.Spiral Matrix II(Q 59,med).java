class Solution {
    public int[][] generateMatrix(int n) {
        int max_r = n-1, max_c =n-1;
        int curr =0, total = (max_r+1) * (max_c+1);
        int [][] spiral = new int [n][n];
        int counting =1;
        int curr_r = 0,curr_c=0;
        while(curr < total){
            for(int i=curr_r,j=curr_c;j<=max_c && curr<total;j++){
                spiral[i][j] = counting;
                counting++;
                curr++;
            }
            curr_r++;
            for(int i=curr_r,j=max_c;i<=max_r && curr<total;i++){
                spiral[i][j] = counting;
                counting++;
                curr++;
            }
            for(int i=max_r,j=max_r-1;j>=curr_c && curr<total ;j--){
                spiral[i][j] = counting;
                counting++;
                curr++;
            }
            
            for(int i=max_r-1,j=curr_c;i>=curr_r && curr<total ;i--){
                spiral[i][j] = counting;
                counting++;
                curr++;
            }
            curr_c++;
            max_r--;
            max_c--;
        }
        return spiral;
    }
}