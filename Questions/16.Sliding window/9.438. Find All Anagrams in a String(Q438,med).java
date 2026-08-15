class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (m > n) return result;

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];
        for (char c : p.toCharArray()) pFreq[c - 'a']++;

        for (int right = 0; right < n; right++) {
            windowFreq[s.charAt(right) - 'a']++;

            int left = right - m + 1;
            if (left > 0) {
                windowFreq[s.charAt(left - 1) - 'a']--;
            }

            if (left >= 0 && Arrays.equals(pFreq, windowFreq)) {
                result.add(left);
            }
        }
        return result;
    }
}

// tc : O(n) | sc : O(1) (constant space for frequency arrays of size 26)

/*

in go language : 
func findAnagrams(s string, p string) []int {
    result := []int{}
    n, m := len(s), len(p)
    if m > n {
        return result
    }

    var pFreq, windowFreq [26]int
    for i := 0; i < m; i++ {
        pFreq[p[i]-'a']++
    }

    for right := 0; right < n; right++ {
        windowFreq[s[right]-'a']++

        left := right - m + 1
        if left > 0 {
            windowFreq[s[left-1]-'a']--
        }

        if left >= 0 && windowFreq == pFreq {
            result = append(result, left)
        }
    }
    return result
}


*/