class Solution {
    public void solveSudoku(char[][] board) {
        if (board==null || board.length == 0) return  ; 
        solve_board(board);
    }
    
    
    
    public boolean solve_board(char [][] board ){
      for(int i =0 ; i<board.length ; i++){
          for(int j=0 ; j<board[0].length ; j++){
              
              
          if(board[i][j] == '.'){
              for(char num = '1' ; num <= '9' ; num++){
                  if(is_Valid(board, i,j,num)) {
                      board[i][j] = num  ;
                      // recursion 
                      if(solve_board(board)) {
                           return true ;  // it's the solution return true 
                      }
                      
                      else {
                          board[i][j]  = '.' ;  // Otherwise go back  
                      } 
                      
                      
                      
                  }
              }
              
              return false ; 
          }
           // if things   
              
          }
      }
        
        return true ; 
     
    }
    
    
    private boolean  is_Valid(char [][] board , int row , int col , char num) {
        for (int uk = 0; uk < 9; uk++){
            // check row 
            
            if(board[uk][col] != '.'  && board[uk][col] == num ) return false ;  // columnwise checking
            
            if(board[row][uk] != '.' && board[row][uk] == num) return false ;  // rowise checking 
            
            if(board[3*(row/3) + uk/3][3*(col/3) +  uk % 3 ] != '.' && board[3*(row/3) + uk/3][3*(col/3) + uk % 3 ] == num) return false ; 
        }
        
        return true ; 
    }
    
    
}