/*
Problem

Given n pairs of parentheses, generate all combinations of well-formed parenthesis strings.

Example: n = 3 → ["((()))","(()())","(())()","()(())","()()()"]

Approach: Backtracking with two counters

Rather than generating all 2^(2n) possible strings and filtering for validity (wasteful — most are invalid), we prune as we build: only add a character if it keeps the string on a path that could still become valid.

The key insight: track open (how many ( used so far) and close (how many ) used so far).

You can add ( any time open < n.
You can add ) only when close < open — i.e., there's an unmatched ( waiting to be closed. This is exactly what prevents invalid strings like ()) from ever being built.
*/
/*
— this undo step is what makes it a proper DFS-over-choices rather than a single linear buildup.

Complexity
Time: O(4ⁿ / √n) — this is the nth Catalan number (the actual count of valid strings), which bounds the total work since every recursive call either leads to a valid string or gets pruned before wasting further work.
Space: O(n) for recursion depth (the string never exceeds 2n characters) + O(4ⁿ/√n) to store all output strings.
Interview talking points
"I'm using two counters instead of an actual stack, similar to Minimum Add to Make Parentheses Valid — I only need counts, not the specific bracket types, since there's only one bracket type here."
"The pruning condition close < open is what keeps every generated string valid by construction — I never generate an invalid string and then filter it out, which is the naive/wasteful approach."
"This is the classic backtracking template: make a choice, recurse, undo the choice (backtrack), try the next choice. The StringBuilder + deleteCharAt pattern is much cheaper than string concatenation (current + "(") since strings are immutable in Java and concatenation would create a new object at every single recursive call."
*/


import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1); // undo — backtrack
        }

        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1); // undo — backtrack
        }
    }
}

