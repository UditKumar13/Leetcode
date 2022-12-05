class Solution {
    public int longestPalindrome(String s) {
        int []freq = new int[128];
        for(char ch : s.toCharArray()){
            freq[ch]++;
        }
        // frequency array created
        int oddOccurences = 0; 
        for(int num : freq){
            oddOccurences += num & 1;
        }
        return s.length() - oddOccurences + (oddOccurences>0 ? 1 : 0);
    }
}