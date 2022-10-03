Q
Given a string str containing only a and b, find the longest substring of str such that str does not contain more than two contiguous occurrences of a and b.

Example 1:
Input: aabbaaaaabb
Output: aabbaa
Example 2:
Input: aabbaabbaabbaaa
Output: aabbaabbaabbaa

class Solution {

    public static String longestValidString(String s) {
        int st = 0, count =0, maxLen = 0, st_ans = 0;
        
        count = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
                count = 1;
            }
            if(count<=2){
             int validLen = i - st + 1;
             if(validLen > maxLen) {
	     maxLen = validLen;
             st_ans = st;}
            }else{
                st = i-1;
                count = 2;
            }
        }
        
        return s.substring(st_ans,st_ans+maxLen);
    }
