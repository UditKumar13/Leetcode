QGiven a string S containing only characters a and b. A substring (contiguous fragment) of S is called a semi-alternating substring if it does not contain three identical consecutive characters. In other words, it does not contain either 'aaa' or 'bbb' substrings. Note that the whole S is its own substring.


import java.util.Scanner;

class Solution {
    public static int semiSubstring(String s) {
        int maxLen = 0, start = 0, count =1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
             count = 1;   
            }
            if(count <=2){
                int validEleLen = i - start + 1;
                if(validEleLen > maxLen){
                    maxLen = validEleLen;
                }
            }else{
                count = 2;
                start = i-1;
            }
        }
        return maxLen;
    }
}