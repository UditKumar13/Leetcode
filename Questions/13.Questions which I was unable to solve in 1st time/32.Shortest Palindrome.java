class Solution {
    public String shortestPalindrome(String s) {
        String str = s + "#" + new StringBuilder(s).reverse().toString();
        int lps = LPS(str);
        
        String ans = new StringBuilder(s.substring(lps)).reverse().toString() + s;
        return ans;
    }
    
    public int LPS(String st){
        int[]lps = new int[st.length()];
        
        int len = 0;
        int i=1;
        while(i<st.length()){
            if(st.charAt(i) == st.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len>0){
                    len = lps[len-1];
                }else{
                    i++;
                }
            }
        }
        
        return lps[lps.length-1];
    }
}