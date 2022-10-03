
// Priority Queue 

//TC(O( n + k.logn))
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        
        PriorityQueue <Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int ele : nums){
            pq.offer(ele);
        }
        int k_max_ele = -1; 
        while(k>0){
           k_max_ele =  pq.poll() ; 
           k-- ; 
        }
        
        return k_max_ele ; 
    }
}

// Quick  Select Method
// TC(O(n))
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }
    
    public int quickSelect(int[] nums, int start, int end, int k){
        if (start > end) return Integer.MAX_VALUE;
        
        int left = start;
        int pivot = nums[end];
        for(int i = start; i< end; i++){
            if(nums[i] <= pivot) swap(nums, left++, i); // put numbers < pivot to pivot's left
        }
        
        swap(nums, left, end);
        
        if(left==k) 
            return nums[left]; //this is kth smallest number
        
        else if(left < k)
            return quickSelect(nums,left+1,end,k);
        
        else 
            return quickSelect(nums,start,left-1,k);
              
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}