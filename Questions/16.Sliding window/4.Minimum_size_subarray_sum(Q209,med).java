class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       // brute force is n^2
      // elaborate more: 
      int min_length = 0;
      int curr_sum = 0;
      Queue<Integer> q = new LinkedList<Integer>();
      for(int i=0; i<nums.length; i++){
        q.add(nums[i]);
        curr_sum += nums[i];
        while(curr_sum >= target){
          if(min_length == 0) min_length = q.size();
          else min_length = Math.min(min_length, q.size());
          curr_sum -= q.poll();
        }
      }
      return min_length;
    }
}