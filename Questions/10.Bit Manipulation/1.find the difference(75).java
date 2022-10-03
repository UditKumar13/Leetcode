class Solution {
    public char findTheDifference(String s, String t) {
        
  // bit manipulation 
  // xor operator 
      
      int a = t.length(); 
      char ans = t.charAt(a-1);
      
      for (int  i =0 ; i<s.length() ; i++){
        ans ^= s.charAt(i) ;
        ans ^= t.charAt(i);
      }
      
      return ans ; 
      
    }
}