class Solution {
    public boolean canJump(int[] nums) {
        int minMoves = 0;
        for(int i=nums.length-2;i>=0;i--){
            minMoves++;
            if(nums[i] >= minMoves){
                minMoves = 0;
            }
        }
        
        return (minMoves == 0) ? true : false;
    }
}

// TC : O(N)
// SC : O(1)

// Intution : Inuttion  is that, we will decide from the back, if the current pos can be satisfied with the minMoves, 
// we update the minMoves to be zero 
