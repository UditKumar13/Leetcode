class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        
        List<Integer> spiral = new ArrayList<>();
        int max_r = mat.length-1, max_c= mat[0].length-1;
        int total = (max_r+1) * (max_c+1),curr = 0;
        int curr_r =0,curr_c=0;
        while(curr < total){
            for(int i=curr_r,j=curr_c;j<=max_c && curr<total;j++){
                spiral.add(mat[i][j]);
                curr++;
            } 
            curr_r++;
            for(int i=curr_r,j=max_c;i<=max_r && curr<total;i++){
                spiral.add(mat[i][j]);
                curr++;
            }
            for(int i=max_r,j=max_c-1;j>=curr_c && curr<total;j--){
                spiral .add(mat[i][j]);
                curr++;
            }
            for(int i=max_r-1,j=curr_c;i>=curr_r && curr<total;i--){
                spiral.add(mat[i][j]);
                curr++;
            }
            curr_c++;
            max_c--;
            max_r--;
        }
        return spiral ;
    }
}