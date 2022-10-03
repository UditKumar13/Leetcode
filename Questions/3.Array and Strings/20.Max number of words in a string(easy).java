class Solution {
    public int mostWordsFound(String[] sentences) {
       
      int len = sentences.length ;
      int ans = 0 ; 
      String temp = "" ; 
      for (int i = 0; i< len ; i++){
        int max = 0 ; 
      temp = sentences[i];
      for (int j =0;j<temp.length() ; j++){
        char ch =  temp.charAt(j);
        
        if (ch == ' '){
          max++ ; 
        }
      }
        if (max > ans){
          ans = max ; 
        }
      }
      
      return ans+1 ;
    }
}