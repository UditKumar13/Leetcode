class Solution {

    // naive approach  :

//     Complexity Analysis

// Time Complexity: O(n² × k) where k = 26 (number of distinct characters)

// O(n²) for all substrings
// O(k) to check if balanced


// Space Complexity: O(26) = O(1)

// Improvement Over Approach 1

// No redundant frequency counting
// Better constant factor
    public int longestBalanced(String s) {
        int n = s.length();
        if(n == 1) return 1;
        int maxLength = 0;
        for (int i=0; i<n; i++){
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int j = i; j<n; j++){
                char c = s.charAt(j);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
                if (isBalanced(freqMap)) maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }

    private boolean isBalanced(Map<Character, Integer> freqMap) {
        int targetFreq = -1;
        
        for (int freq : freqMap.values()) {
            if (targetFreq == -1) {
                targetFreq = freq;
            } else if (freq != targetFreq) {
                return false;
            }
        }
        
        return true;
    }
}