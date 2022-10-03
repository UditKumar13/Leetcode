
// 84 % runtime 

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        
        Arrays.sort(strs) ; 
        int len = strs.length -1 ; 
        
        
        int track = 0 ; 
        
        String one = strs[0] ;
        String last = strs [len] ;
        
        int min = Math.min(one.length() , last.length () ) ;
        
        
        
        for (int j = 0 ; j<min ; j++){
            
            if (one.charAt(j) == last.charAt(j)) track++ ; 
            
            else break ; 
        }
        
      String ans = strs[0].substring(0,track) ; 
      return ans ; 
    }
}



//  best solution 100 % solution :



class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 0 ) return "" ;
        
        String ans = strs[0] ; // let us assume it is our ans 
        
        for (int i = 1 ; i< strs.length ; i++){
            
            while(strs[i].indexOf(ans) != 0){
                // != 0 means our next string mein ans as a substring nhi hai toh
                // currently ans can't be our ans 
                // we have to decrease the length 
                
                ans = ans.substring(0,ans.length() -1); // decreasing length by 1
                if (ans.isEmpty()) return "" ; // agar ans hi nhi hai toh null string hi ans hai 
            }
            
       
        }
        
             return ans ; 
     }
} 
