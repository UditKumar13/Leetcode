class Solution {
    public int titleToNumber(String str) {
         int len =  str.length();
        int res = 0 ;
        int  place_val =  0 ; 
        for (int i =len-1 ; i >=0 ; i--){
            
            char ch = str.charAt(i) ;
            int val = (int)ch - 64 ;
            res += val * Math.pow(26,place_val) ; 
            place_val++ ; 
            
        }
        
        return res ;    
    }
}