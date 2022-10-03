class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        
        // let us do the n queen problem
        
        char [][] board = new char [n][n] ; 
        
        for (int i =0 ; i<n ; i++)
            for (int j = 0 ; j<n; j++)
                board[i][j] = '.' ;
        
        
        List<List<String>> ans = new ArrayList<List<String>>() ;  
        
        lekraa(board, 0 , ans) ; 
        
        return ans ; 
               
    }
    
    
    public void lekraa(char [][] board, int col, List<List<String>> ans){
        
        
        // base case 
        
        if (col == board.length){
            ans.add(construct(board)) ; 
            return ; 
        }
        
        for (int i=0  ; i<board.length ; i++){
            
           if (valid_move(board,i,col)){
               // valid move
               
               board[i][col] = 'Q';
               //recursion 
               lekraa(board, col+1,ans) ;
               
               board[i][col]  = '.' ; 
               
           }
        }
        
    }
    
    boolean valid_move(char [][] board , int x ,  int y ){
        
        for (int i=0 ; i< board.length ; i++ ){
            for (int  j= 0 ; j< y ; j++){
                if (board[i][j] == 'Q' && (x==i || x + j == y + i || x + y == i + j )){
                    return false ; 
                    
                    
                    // x + j == y + i is checking the left diagnal 
                    // x + y == i + j  is checking the right diagnal 
                    
                }
            }
        }
        
        return true ; 
    }
    
    private List<String> construct(char [][] board) {
        List<String> res = new ArrayList<String>() ;
        
        
        for (int  i = 0; i < board.length ; i++){
            String uk = new String(board[i]) ; 
            res.add(uk) ; 
        }
        
        return res ; 
    }
}