class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < n; j++) {
                freq.merge(nums[j], 1, Integer::sum);
                if (freq.size() == k) {
                    count++;
                } else if (freq.size() > k) {
                    break; // distinct count only grows as j increases, no point continuing
                }
            }
        }
        return count;
    }
}

// Time: O(n^2) | Space: O(n) (for the frequency map)

// optimal solution using sliding window technique

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    private int atMostKDistinct(int[] nums, int k) {
        if (k < 0) return 0;

        int[] freq = new int[nums.length + 1]; // values bounded by array length per constraints
        int left = 0;
        int distinct = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (freq[nums[right]] == 0) {
                distinct++;
            }
            freq[nums[right]]++;

            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }

            count += right - left + 1; // every subarray ending at "right", starting anywhere from left..right
        }
        return count;
    }
}

// Time: O(n) | Space: O(n) (for the frequency array)
