// Brute force 

// TC O(n) SC O(1)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int theUnique = 0;
        for (int element : nums){
            theUnique ^= element;
        }
        
        return theUnique;
    }
}


// optimized with the binary search 



// TC O(logn) SC O(1)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-2;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(nums[mid] == nums[mid^1]){
                // xor takes care of the 
                low = mid + 1;
            }
            
            else{
                high = mid - 1;
            }
        }
        // once low crosses the high
        return nums[low];
        // left half 1st instance even, second instance odd  Right half 1st instance odd and second instance even
        
    }
}