class Solution {
    public int maxProduct(int[] nums) {
        int maxP = Integer.MIN_VALUE;
        int P = nums[0];
        if(nums[0] > maxP) maxP = nums[0];
        if(P == 0) P = 1;
        for(int i=1;i<nums.length;i++){
            P *= nums[i];
            maxP = Math.max(maxP,P);
             if(P == 0) P = 1;
        }
        
        P = nums[nums.length-1];
        if(maxP < P) maxP = P;
        if(P == 0) P = 1;
        for(int i=nums.length-2;i>=0;i--){
            P *= nums[i];
            maxP = Math.max(maxP,P);
            if(P == 0) P = 1;
        }
        
        return maxP;
    }
   
}

// Tc  : O(n)
// Intution is to make the P = 1 when the P got 0, 
// also we have to update the product from both sides L to R, and R to L.



