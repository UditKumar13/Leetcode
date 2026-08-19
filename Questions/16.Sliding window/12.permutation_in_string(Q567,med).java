
// Complexity
// TimeSpaceO(26 × n) ≈ O(n)O(1)


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int window = s1.length();
        
        // Build frequency array for s1 and first window of s2
        for (int i = 0; i < window; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        // Check first window
        if (matches(s1Count, s2Count)) return true;
        
        // Slide the window across s2
        for (int i = window; i < s2.length(); i++) {
            // Add new character (right side)
            s2Count[s2.charAt(i) - 'a']++;
            
            // Remove old character (left side)
            s2Count[s2.charAt(i - window) - 'a']--;
            
            // Compare frequency arrays
            if (matches(s1Count, s2Count)) return true;
        }
        
        return false;
    }
    
    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}

// Time: O(n)
// Space: O(1)

/*
in go language :

func checkInclusion(s1 string, s2 string) bool {
	if len(s1) > len(s2) {
		return false
	}

	var s1Count, s2Count [26]int
	window := len(s1)

	// Build frequency array for s1 and first window of s2
	for i := 0; i < window; i++ {
		s1Count[s1[i]-'a']++
		s2Count[s2[i]-'a']++
	}

	// Check first window
	if matches(s1Count, s2Count) {
		return true
	}

	// Slide the window across s2
	for i := window; i < len(s2); i++ {
		// Add new character (right side)
		s2Count[s2[i]-'a']++

		// Remove old character (left side)
		s2Count[s2[i-window]-'a']--

		// Compare frequency arrays
		if matches(s1Count, s2Count) {
			return true
		}
	}

	return false
}

func matches(arr1, arr2 [26]int) bool {
	return arr1 == arr2 // Go allows direct fixed-size array comparison
}
*/

