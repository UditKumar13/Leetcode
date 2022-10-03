class Solution {
    public int halveArray(int[] nums) {
        
        PriorityQueue <Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());
        double sum = 0;
        for(int ele : nums){
            sum += ele;
            pq.offer((double)ele);
        }
        
        double base = sum/2;
        int min_op =0;
        while(base < sum){
            min_op++;
            double max_ele = pq.poll();
            sum -= max_ele;
            max_ele /= 2;
            sum += max_ele;
            pq.offer(max_ele);
            
        }
        
        return min_op;
        
        
    } 
}