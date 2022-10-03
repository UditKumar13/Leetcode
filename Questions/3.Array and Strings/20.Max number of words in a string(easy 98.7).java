class Solution {
    public int mostWordsFound(String[] sentences) {
       
      int len = sentences.length ;
      
      int max =  0 ;
      String temp = "" ; 
     for (int i =0 ; i<len ; i++){
       temp  = sentences[i] ;
       
       max = Math.max(max,(temp.split(" ").length)) ; 
       
     }
      
      return max ; 
}
}