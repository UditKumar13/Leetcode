class Solution {
    static int unequal_Start = 0;
    static int unequal_End = 0; 
    public boolean isPali(String s){
        int len = s.length();
        int st = 0;
        int end = len-1;
        while(st <= end){
            if(s.charAt(st) != s.charAt(end))  {
                unequal_Start = st;
                unequal_End = end;
                return false;
            }
            st++;
            end--;
            
        }
        
        return true;
    }
    
        public boolean isPali_Modified(String s, int left,int right){
        int len = s.length();
        while(left <= right){
            if(s.charAt(left) != s.charAt(right))  {
                return false;
            }
            left++;
            right--;
            
        }
        
        return true;
    }

    
    public boolean validPalindrome(String s) {
        boolean deleteNothing = isPali(s);
        if(deleteNothing == true) return true;
        int st = unequal_Start;
        int end = unequal_End;
        boolean delete_Start =isPali_Modified(s,st+1,end);
        boolean delete_End = isPali_Modified(s,st,end-1);
        if(delete_Start || delete_End) return true;
        
        return false;
        
    }
}