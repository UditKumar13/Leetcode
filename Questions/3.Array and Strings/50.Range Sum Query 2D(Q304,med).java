class NumMatrix {
    private int[][] prefixSum;
    
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        prefixSum = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0) prefixSum[i][j] = matrix[i][j];
                else 
                prefixSum[i][j] = matrix[i][j] + prefixSum[i][j-1];
            }
            
        }
        
        
      
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
     int sum = 0, j = col1;
        for(int i = row1; i<= row2; i++){
            if (col1 == 0)
            sum += prefixSum[i][col2];
            else 
            sum += prefixSum[i][col2] - prefixSum[i][col1-1];
        }
        
        return sum;
        
        
    }
}

// TC : O(n) beacuase of Prefix Sum
