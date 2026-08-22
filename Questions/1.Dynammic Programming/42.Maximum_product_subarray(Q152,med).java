// Maximum Product Subarray (LC 152): given an array,
//  find the contiguous subarray with the largest product.

// Why this is trickier than Maximum Subarray (Kadane's, Q4): with sums, 
// a negative number always makes things worse. But with products, two negatives make a positive
//  — so a small (very negative) running product can suddenly become the best product if you multiply
//   it by another negative. This means you need to track both the running max AND running min at each 
//   position, because today's min could become tomorrow's max.


// Recurrence: at each index i, the best product ending here is one of three things:
//  nums[i] alone, nums[i] * (best max ending at i-1), or nums[i] * (best min ending at i-1) 
//  (this last one matters specifically when nums[i] is negative):

// maxEndingHere[i] = max(nums[i], nums[i] * maxEndingHere[i-1], nums[i] * minEndingHere[i-1])
// minEndingHere[i] = min(nums[i], nums[i] * maxEndingHere[i-1], nums[i] * minEndingHere[i-1])

// Answer = max over all maxEndingHere[i] (best subarray could end anywhere — same as Max Subarray).

class Solution {
    public int maxProduct(int[] nums) {
        int best = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                best = Math.max(best, product);
            }
        }
        return best;
    }
}

// Brute Force (Check every subarray) — O(n²) time, O(1) space

/*
in go : 
func maxProduct(nums []int) int {
    best := nums[0]
    for i := 0; i < len(nums); i++ {
        product := 1
        for j := i; j < len(nums); j++ {
            product *= nums[j]
            if product > best {
                best = product
            }
        }
    }
    return best
}
*/

class Solution {
    private long[][] memo; // memo[i] = {maxEndingHere, minEndingHere}
    private boolean[] computed;
    private int best;
    
    public int maxProduct(int[] nums) {
        int n = nums.length;
        memo = new long[n][2];
        computed = new boolean[n];
        best = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long[] res = helper(nums, i);
            best = (int) Math.max(best, res[0]);
        }
        return best;
    }
    private long[] helper(int[] nums, int i) {
        if (computed[i]) return memo[i];
        if (i == 0) {
            memo[i] = new long[]{nums[0], nums[0]};
            computed[i] = true;
            return memo[i];
        }
        long[] prev = helper(nums, i - 1);
        long candidate1 = nums[i];
        long candidate2 = nums[i] * prev[0];
        long candidate3 = nums[i] * prev[1];
        long maxHere = Math.max(candidate1, Math.max(candidate2, candidate3));
        long minHere = Math.min(candidate1, Math.min(candidate2, candidate3));
        memo[i] = new long[]{maxHere, minHere};
        computed[i] = true;
        return memo[i];
    }
}

// Top-Down (Memoization) — O(n) time, O(n) space

// Define helper(i) returning both the max and min product ending at index i —
//  since Java/Go don't return tuples as easily, we use small arrays or two parallel memo tables.


/*

in go  : 
func maxProduct(nums []int) int {
    n := len(nums)
    memoMax := make([]int, n)
    memoMin := make([]int, n)
    computed := make([]bool, n)
    
    var helper func(i int) (int, int)
    helper = func(i int) (int, int) {
        if computed[i] {
            return memoMax[i], memoMin[i]
        }
        if i == 0 {
            memoMax[i], memoMin[i] = nums[0], nums[0]
            computed[i] = true
            return memoMax[i], memoMin[i]
        }
        prevMax, prevMin := helper(i - 1)
        c1 := nums[i]
        c2 := nums[i] * prevMax
        c3 := nums[i] * prevMin
        maxHere := max3(c1, c2, c3)
        minHere := min3(c1, c2, c3)
        memoMax[i], memoMin[i] = maxHere, minHere
        computed[i] = true
        return maxHere, minHere
    }
    
    best := nums[0]
    for i := 0; i < n; i++ {
        m, _ := helper(i)
        if m > best {
            best = m
        }
    }
    return best
}
func max3(a, b, c int) int {
    m := a
    if b > m { m = b }
    if c > m { m = c }
    return m
}
func min3(a, b, c int) int {
    m := a
    if b < m { m = b }
    if c < m { m = c }
    return m
}
*/

// Notice how much heavier this is compared to earlier top-down solutions — carrying two 
// running values through recursion is clunky. That's a strong signal this problem is naturally 
// suited to bottom-up rolling variables, which is next.

class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int best = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int candidateMax = Math.max(num, Math.max(num * currMax, num * currMin));
            int candidateMin = Math.min(num, Math.min(num * currMax, num * currMin));
            currMax = candidateMax;
            currMin = candidateMin;
            best = Math.max(best, currMax);
        }
        return best;
    }
}

// Optimal (Bottom-Up, rolling variables) — O(n) time, O(1) space

// Track currMax and currMin as you scan left to right — the same "roll two variables forward" 
// pattern as House Robber, just with two different running values (max and min) instead of two
//  previous values.

/*
in go : 

func maxProduct(nums []int) int {
    currMax, currMin := nums[0], nums[0]
    best := nums[0]
    
    for i := 1; i < len(nums); i++ {
        num := nums[i]
        candMax := max3(num, num*currMax, num*currMin)
        candMin := min3(num, num*currMax, num*currMin)
        currMax, currMin = candMax, candMin
        if currMax > best {
            best = currMax
        }
    }
    return best
}
func max3(a, b, c int) int {
    m := a
    if b > m { m = b }
    if c > m { m = c }
    return m
}
func min3(a, b, c int) int {
    m := a
    if b < m { m = b }
    if c < m { m = c }
    return m
}
*/