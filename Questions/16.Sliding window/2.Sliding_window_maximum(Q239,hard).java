class Solution {
    
   
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int size = nums.length - k +1;
        int [] swm = new int [size];
        int idx = 0;
        Deque<Integer> kWindow = new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(!kWindow.isEmpty() && i-k == kWindow.peek()){
                kWindow.poll();
            }
            
            while(!kWindow.isEmpty() && nums[kWindow.peekLast()] < nums[i]){
                kWindow.pollLast();
            }
            
            kWindow.offer(i);
            if(i >= k-1){
                swm[idx++] = nums[kWindow.peek()];
            }
        }
        return swm;
    }
}
