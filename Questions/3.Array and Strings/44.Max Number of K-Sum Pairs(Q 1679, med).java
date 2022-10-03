class Solution {
    public int maxOperations(int[] nums, int k) {
        int count =0 ;
        
        Arrays.sort(nums);
        int l=0, r = nums.length-1;
        while(l<r){
            int sum = nums[l] + nums[r];
            if(sum == k){
                count++;
                l++;
                r--;
            }
            
            else if(sum > k) {
                r--;
            }
            
            
            else {
                l++;
            }
        }
        return count;
    }
}