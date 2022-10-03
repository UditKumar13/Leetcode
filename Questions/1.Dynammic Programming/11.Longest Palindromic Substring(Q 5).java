class Solution {
    private int lo,maxLen;
    
    public String longestPalindrome(String s) {
        int len = s.length()-1;
        if(s.length()<2) return s;
        
        for(int i=0; i<s.length();i++){
            extendPali(s,i,i); // odd length
            extendPali(s,i,i+1); // even length
        }
        
        return s.substring(lo,lo+maxLen);
    }
    
    public void extendPali(String s, int j, int k){
        while(j>=0 && k<=s.length()-1 && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        
        if(maxLen < k-j-1){
            lo = j + 1;
            maxLen = k-j-1;
        }
    }
    
 
}