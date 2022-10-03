class Solution {
    public char findTheDifference(String s, String t) {
        
  // bit manipulation 
  // xor operator 
  // instaead of using the xor operator use the common sense ans use addition and subtraction 
      
  int charCode = t.charAt(s.length());
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i) {
              charCode -= (int)s.charAt(i);
              charCode += (int)t.charAt(i); 
        }
        return (char)charCode;
      
    }
}