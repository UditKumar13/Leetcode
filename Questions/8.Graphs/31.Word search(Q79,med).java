class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0) && helper(board,word,i,j,0))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean helper(char [][]board, String word,int i,int j,int pos){
        
        if(pos == word.length()) return true;
        if(i<0 || j<0 || i >= board.length || j >= board[0].length) return false;
        
        if(word.charAt(pos) != board[i][j]) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        if(helper(board,word,i+1,j,pos+1) || helper(board,word,i-1,j,pos+1) || 
           helper(board,word,i,j-1,pos+1) || helper(board,word,i,j+1,pos+1)){
            return true;
        }
        board[i][j] = temp;
        return false;
        
    }
}