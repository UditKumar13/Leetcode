class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if (m > n) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;

        int bestLen = Integer.MAX_VALUE, bestStart = -1;

        for (int i = 0; i < n; i++) {
            int[] window = new int[128];
            for (int j = i; j < n; j++) {
                window[s.charAt(j)]++;
                if (contains(window, need)) {
                    if (j - i + 1 < bestLen) {
                        bestLen = j - i + 1;
                        bestStart = i;
                    }
                    break; // shortest valid window starting at i found, no need to extend further
                }
            }
        }
        return bestStart == -1 ? "" : s.substring(bestStart, bestStart + bestLen);
    }

    private boolean contains(int[] window, int[] need) {
        for (int c = 0; c < 128; c++) {
            if (window[c] < need[c]) return false;
        }
        return true;
    }
}

// brute force approach : O(n^2) | O(1) (constant space for frequency arrays of size 128)

/*

optimal approach : sliding window technique



*/

class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;

        int required = 0;
        for (int count : need) if (count > 0) required++;

        int[] window = new int[128];
        int have = 0;
        int left = 0;
        int bestLen = Integer.MAX_VALUE, bestStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window[c]++;
            if (need[c] > 0 && window[c] == need[c]) {
                have++;
            }

            while (have == required) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                char lc = s.charAt(left);
                window[lc]--;
                if (need[lc] > 0 && window[lc] < need[lc]) {
                    have--;
                }
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}

// tc : O(n) | sc : O(1) (constant space for frequency arrays of size 128)
