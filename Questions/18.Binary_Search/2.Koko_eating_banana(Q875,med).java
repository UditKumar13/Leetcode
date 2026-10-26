class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int p : piles) maxPile = Math.max(maxPile, p);

        for (int k = 1; k <= maxPile; k++) {
            if (hoursNeeded(piles, k) <= h) {
                return k; // pehla valid k jo milega, wahi minimum hoga
            }
        }
        return maxPile;
    }

    private long hoursNeeded(int[] piles, int k) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k; // ceil division
        }
        return hours;
    }
}

// Brute Force — O(n × max(piles))

// Idea: k = 1 se start karo, ek-ek badhate jao, jab tak hours(k) <= h na ho jaaye.

// optimal 

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0;
        for (int p : piles) hi = Math.max(hi, p);

        int ans = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hoursNeeded(piles, mid) <= h) {
                ans = mid;
                hi = mid - 1; // chhoti speed try karo
            } else {
                lo = mid + 1; // speed badhao
            }
        }
        return ans;
    }

    private long hoursNeeded(int[] piles, int k) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k;
        }
        return hours;
    }
}

// Optimal — Binary Search on Answer — O(n log(maxPile))

// Idea: k badhne se hours kam hote hain (monotonic) → binary search chalega


// in go : 

// func minEatingSpeed(piles []int, h int) int {
//     maxPile := 0
//     for _, p := range piles {
//         if p > maxPile {
//             maxPile = p
//         }
//     }

//     for k := 1; k <= maxPile; k++ {
//         if hoursNeeded(piles, k) <= h {
//             return k
//         }
//     }
//     return maxPile
// }

// func hoursNeeded(piles []int, k int) int {
//     hours := 0
//     for _, p := range piles {
//         hours += (p + k - 1) / k // ceil division
//     }
//     return hours
// }


