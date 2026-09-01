

class Solution {
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private int[][] cache;
    private int rows, cols;
    private int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        cache = new int[rows][cols]; // 0 = not computed yet

        int longest = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                longest = Math.max(longest, dfs(i, j));
            }
        }
        return longest;
    }

    private int dfs(int i, int j) {
        if (cache[i][j] != 0) return cache[i][j]; // already computed

        int best = 1; // path of just this cell
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < rows && nj >= 0 && nj < cols
                    && matrix[ni][nj] > matrix[i][j]) {
                best = Math.max(best, 1 + dfs(ni, nj));
            }
        }

        cache[i][j] = best;
        return best;
    }
}

// Complexity
// Time: O(m·n) — each cell's dfs runs its body exactly once thanks to the cache; every other call 
// is an O(1) cache hit.
// Space: O(m·n) for the cache + O(m·n) worst-case recursion depth (a fully increasing snake path).
// Why memoization is safe here (no cycle risk)

// Unlike general graph DFS, you don't need a "visiting" state to guard against infinite recursion 
// — the strictly-increasing constraint guarantees the recursion graph is a DAG (you can never step 
//     back to a smaller-or-equal value), so plain memoization (no 3-state coloring) is enough.