
TC O(n) SC O(n)
class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long  ans1 = 0, ans2 = 0;
        String addToBeginning = pattern.charAt(0) + text;
        String addToEnd = text + pattern.charAt(1);
        long count = 0;
        for(int i=0; i<addToBeginning.length();i++){
            if(addToBeginning.charAt(i) == pattern.charAt(0)) count++;
            else if(addToBeginning.charAt(i) == pattern.charAt(1)) ans1 += count;
        }
        // checking a special case 
        if(pattern.charAt(0) == pattern.charAt(1)){
            long oneLess = count-1;
            ans1 = ((count) * (oneLess))/2;
        }
        
        count = 0;
        
        for(int i=addToEnd.length()-1; i>=0;i--){
            if(addToEnd.charAt(i) == pattern.charAt(1)) count++;
            else if(addToEnd.charAt(i) == pattern.charAt(0)) ans2 += count;
        }
        // checking a special case 
        if(pattern.charAt(0) == pattern.charAt(1)){
            long oneLess = count-1;
            ans2 = ((count) * (oneLess))/2;
        }
        
        return Math.max(ans1,ans2);
        
    }
}