class Solution {
    public String restoreString(String s, int[] arr) {
        
      char [] c = new char [arr.length] ;
      
      
      for (int  i =0 ; i<arr.length ; i++){
        
        c[arr[i]] =  s.charAt(i);
        
      }
      
      return new String(c); 
    }
}