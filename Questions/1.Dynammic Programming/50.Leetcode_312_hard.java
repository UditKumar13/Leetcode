// Complexity: O(n!) time, since every burst order is tried, and O(n) space.

class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> balloons = new ArrayList<>();
        for (int x : nums) balloons.add(x);
        return helper(balloons);
    }

    private int helper(List<Integer> balloons) {
        if (balloons.isEmpty()) return 0;

        int best = 0;
        for (int i = 0; i < balloons.size(); i++) {
            int left  = (i == 0) ? 1 : balloons.get(i - 1);
            int right = (i == balloons.size() - 1) ? 1 : balloons.get(i + 1);
            int coins = left * balloons.get(i) * right;

            int removed = balloons.remove(i);                  // burst it
            best = Math.max(best, coins + helper(balloons));
            balloons.add(i, removed);                          // backtrack
        }
        return best;
    }
}

