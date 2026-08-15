// 🧠 Interview Thinking Flow
// Naive → O(n²) or O(n³):
// Check every possible substring, use a HashSet to verify no duplicates. Track max length.

// TC: O(n³) | SC: O(n)

// Observation:
// You don't need to recheck from scratch every time. Use a sliding window — expand right, and when a duplicate is found, shrink from the left until the window is valid again.
// Optimal → O(n):
// Maintain a window [left, right] and a HashSet of current characters. Move right forward always. When s[right] is already in the set, move left forward removing characters until the duplicate is gone.
// How it works:

// right expands the window every iteration.
// If s[right] is already in the set, shrink from left until it's removed.
// Window size at any point is right - left + 1.

// TC: O(n) | SC: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> charIndex = new HashMap<>();
    int maxLen = 0, left = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        
        // if char seen before AND it's inside current window
        if (charIndex.containsKey(c) && charIndex.get(c) >= left) {
            left = charIndex.get(c) + 1;  // shrink window from left
        }
        
        charIndex.put(c, right);  // update last seen index
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
}


/*

in go : 

func lengthOfLongestSubstring(s string) int {
    charIndex := make(map[byte]int)
    maxLen, left := 0, 0
    
    for right := 0; right < len(s); right++ {
        // if char seen before AND it's inside current window
        if idx, ok := charIndex[s[right]]; ok && idx >= left {
            left = idx + 1  // shrink window from left
        }
        
        charIndex[s[right]] = right  // update last seen index
        if right - left + 1 > maxLen {
            maxLen = right - left + 1
        }
    }
    return maxLen
}
*/