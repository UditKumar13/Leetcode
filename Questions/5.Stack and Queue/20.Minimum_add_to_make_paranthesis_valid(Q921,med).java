class Solution {
    public int minAddToMakeValid(String s) {
        int openNeedsClose = 0; // count of unmatched '(' currently open
        int insertions = 0;     // count of ')' we'd need to add right now

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openNeedsClose++;
            } else { // c == ')'
                if (openNeedsClose > 0) {
                    openNeedsClose--; // matches an open '('
                } else {
                    insertions++; // no '(' to match — must insert one right here
                }
            }
        }

        // any '(' still unmatched at the end each need a closing ')'
        return insertions + openNeedsClose;
    }
}

// Time: O(n) | Space: O(1)

