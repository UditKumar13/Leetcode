class Solution {
    public int removePalindromeSub(String s) {
        if(s == null) return 0;
        int minSteps = 0;
        
        minSteps = (s.equals(new StringBuilder(s).reverse().toString())) ? 1:2 ;
        return minSteps;
            
    }
}