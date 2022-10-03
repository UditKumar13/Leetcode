class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0 ; i< 9 ; i++){
            Set <Character> row = new HashSet<>() ; 
             Set <Character> col = new HashSet<>() ; 
             Set <Character> cube = new HashSet<>() ; 
            
            for (int j = 0 ; j< 9 ; j++){
                if (board[i][j] != '.' && (!row.add(board[i][j])))return false ; 
                
                
                // checking row wise 
                if(board[j][i] != '.' && (!col.add(board[j][i]))) return false ; 
                
                //checking column wise
                
             // starting row_cell, col_cell
                
                int st_row_cell =  3*(i/3) ;
                int st_col_cell = 3*(i%3);
                
                
                if (board[st_row_cell + j/3][st_col_cell + j%3] != '.' &&
                   
                   (!cube.add(board[st_row_cell + j/3][st_col_cell + j%3]))){
                    return false ; 
                }
                
                // everytime the inner for loop runs 
                // it is running for 00 01 02     i=1
                //                   10 11 12
                //                   20 21 22 
                
                // then //           03 04 05 
                //                   13 14 15
                //                   23 24 25     i =2

                
                
            }
        } // main for loop ends here 
        
        
        return true ; 
    }
}