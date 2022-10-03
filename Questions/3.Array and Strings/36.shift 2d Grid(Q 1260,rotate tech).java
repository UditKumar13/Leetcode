class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row  = grid.length, col =grid[0].length;
        int total = row*col;
        k = k % (total);
        if (k<0) k = k + total;
        int [] nums = new int [total];
        int idx =0 ; 
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                nums[idx] = grid[i][j];
                idx++;
            }
        }
        int n = nums.length;
        // left shift 
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
        
       
        List<List<Integer>> shift = new ArrayList<>();
         idx=0;
        for(int i=0; i<row;i++){
            List<Integer> li = new ArrayList<>();
            for(int j=0;j<col;j++){
                li.add(nums[idx]);
                idx++;
            }
            shift.add(li);
        }
        
        return shift;
        
    }
    
    public void reverse(int []nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}