
//https://leetcode.com/problems/bitwise-xor-of-all-pairings/discuss/2646708/Easy-solution-Explained-oror-100-faster-oror-Beginner-Friendly-oror-Best-Method

class Solution {
    
    public int xorArr(int []arr){
        int ans = 0;
        for(int x : arr){
            ans ^= x;
        }
        return ans;
    }
    public int xorAllNums(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        if(a % 2 == 0 && b % 2 == 0) return 0;
        int xor1 = xorArr(nums1);
        int xor2 = xorArr(nums2);
        return ((a % 2) == 1 && (b % 2) ==1) ? (xor1 ^ xor2) : ( (a % 2 == 1) ? xor2 : xor1);
    }
}