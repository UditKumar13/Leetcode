class Solution {
    public int[] singleNumber(int[] nums) {
        int xorVal = 0;
        for(int num : nums){
            xorVal ^= num;
        }
        int firstOneBit = (xorVal & -xorVal);
        int onebitSet = 0, oneBitSetNot = 0;
        for(int num : nums){
            if((num & firstOneBit) == 0){
                oneBitSetNot ^= num;
            }else{
                onebitSet ^= num;
            }
        }
        
        return new int[]{onebitSet,oneBitSetNot};
    }
}

// TC : O(n)
// SC : O(1)

Leetcode 260