class Solution {

    public List<String> getAllPossibleSubString(String s){
        int n = s.length();
        List<String> subs = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                subs.add(s.substring(i,j));
            }
        }
        subs.add("");
        return subs;
    }

    public int longestPalindrome(String s, String t) {
        int maxLen = 0; 
        List<String> sSubs= getAllPossibleSubString(s);
        List<String> tSubs = getAllPossibleSubString(t);

        for(String sSub: sSubs){
            for(String tSub: tSubs){
                String combined = sSub + tSub;
                if(isPalindrome(combined)){
                    maxLen = Math.max(maxLen, combined.length());
                }
            }
        }
        return maxLen;
        }

    public boolean isPalindrome(String s){
        if(s == "" || s.length() == 1) return true;
        int n = s.length();
        int i = 0;
        int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

