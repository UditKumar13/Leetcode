
// Approach 1 : 

class Solution {
    public int findMin(int[] nums) {
        
        int min = nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[i] < min) min = nums[i];
        }
        
        return min;
    }
}

// Tc : O(n)
//SC : O(1)


// Approach 2  : 
More optimized 


class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length == 2){
            if(nums[0] < nums[1]) return nums[0];
            else return nums[1];
        }
        
        
        int l = 0, hi = nums.length-1;
        int ans = -1;
        while(l<hi){
            int mid = (l + hi)/2;
            ans = mid;
            if(mid ==0) {
                int a  = nums[mid];
                int b = nums[mid+1];
                a = a < b  ?  a  : b;
                return a;
            }
            if(nums[mid-1] > nums[mid]) return nums[mid];
            if(nums[mid] < nums[hi]){
                // move left 
                hi = mid -1;
            }
            
            else{
                l = mid + 1;
            }
        }
        
        return nums[l];
    }
}

// Tc : O(logn)
//SC : O(1)


