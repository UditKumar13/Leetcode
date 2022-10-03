class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int l =0, r= 0, len = INT_MAX, sum = 0, n = nums.size();
        while(r<n){
            sum += nums[r++];
            while(sum >= target){
                len = min(len,r-l);
                sum -= nums[l++];
            }
            // we are doing it the order of n
            // very good logic 
        }
        
        return len == INT_MAX ? 0: len;
    }
};