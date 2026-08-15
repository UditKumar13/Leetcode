class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int maxFreq = 0;
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);
                int windowLen = j - i + 1;
                if (windowLen - maxFreq <= k) {
                    maxLen = Math.max(maxLen, windowLen);
                }
            }
        }
        return maxLen;
    }
}
// brute force → O(n²) | SC: O(1)
/*


in go language : 

func characterReplacement(s string, k int) int {
    n := len(s)
    maxLen := 0

    for i := 0; i < n; i++ {
        freq := [26]int{}
        maxFreq := 0

        for j := i; j < n; j++ {
            freq[s[j] - 'A']++
            if (freq[s[j]-'A'] > maxFreq){
                maxFreq = freq[s[j]-'A']
            }

            windowLen := j - i + 1
            if windowLen - maxFreq <= k {
                if windowLen > maxLen {
                    maxLen = windowLen
                }
            }
        }

    }
    return maxLen
}
*/


// optimal solution : Sliding window → O(n) | SC: O(1)



class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int maxLen = 0;
        int maxFreq = 0;

        int left = 0;

        for (int right = 0; right < n; right++){
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while (right - left + 1 - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}


/*
optimal solution in go language :
func characterReplacement(s string, k int) int {
    var freq [26]int
    left := 0
    maxFreq := 0
    maxLen := 0

    for right := 0; right < len(s); right++ {
        freq[s[right]-'A']++
        if freq[s[right]-'A'] > maxFreq {
            maxFreq = freq[s[right]-'A']
        }

        for (right-left+1)-maxFreq > k {
            freq[s[left]-'A']--
            left++
        }

        if right-left+1 > maxLen {
            maxLen = right - left + 1
        }
    }
    return maxLen
}

*/