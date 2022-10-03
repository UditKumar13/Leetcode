

class Solution {
    public int myAtoi(String s) {
        if (s == null ) return 0;
        s = s.trim();
        if(s.length() == 0) return 0;
        
        long sum = 0;
        int sign = +1;
        int idx = 0;
        if(s.charAt(0) == '-') sign = -1; 
        idx = (s.charAt(0) == '+' || s.charAt(0) == '-' ) ? 1 : 0 ;
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        while(idx < s.length()){
            char ch = s.charAt(idx);
            if(ch == ' ' || !Character.isDigit(ch)) break;
            
            sum = sum * 10 + ch - '0';
            if(sign == +1 && sum > max) return max;
            if(sign == -1 && sum*-1 < min ) return min;
            idx++;
        }
        
        return (int)(sign*sum);
        
    }
}

// TC  O(n)
// SC O(1)