class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        // <sum%k,index>
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            sum %= k;
            
            if(sum ==0 && i>0) return true; // exact match
            if(map.containsKey(sum) && i-map.get(sum)>1) return true;
            // this trick is being used in many question, it says if we get the same remainder twice that means the multile of k was in between and we check the condition of ateast 2 by i-map.get(sum)>1
            map.putIfAbsent(sum,i);
        }
        return false;
    }
}