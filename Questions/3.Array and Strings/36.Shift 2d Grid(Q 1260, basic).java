class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length, col = grid[0].length;
        int [][] arr = new int [row][col];
         List<List<Integer>> li = new ArrayList<List<Integer>>();
        
        if(k==0) {
              for(int i=0;i<grid.length;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<grid[0].length;j++){
                temp.add(grid[i][j]);
            }
            li.add(temp);
        }
        return li;
    }
        
        
    
        while(k>=1){
              for (int i=0; i<row;i++){
            for(int j=0; j<col;j++){
                if(i == 0 && j == 0){
                    arr[i][j] = grid[row-1][col-1];
                }
                
                else if (j==0){
                    arr[i][j] = grid[i-1][col-1];
                }
                
                else {
                    arr[i][j] = grid[i][j-1];
                }
            }
        }
        
        for(int i=0;i<arr.length;i++){
            for(int j=0; j<arr[0].length;j++){
                grid[i][j] = arr[i][j];
            }
        }
            
            k--;
        }
      
        
        
    
        
       
        for(int i=0;i<arr.length;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<arr[0].length;j++){
                temp.add(arr[i][j]);
            }
            li.add(temp);
            
        }
        return li;
    }
}