class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int num : stones){
            pq.add(num);
        }
        // nlogn
        
        while(pq.size()>1){
            int maxEle = pq.poll();
            int secondMax = pq.poll();
            if(maxEle != secondMax){
                int diff = maxEle-secondMax;
                pq.add(diff);
            }
            
        }
        //O(n)
        
     
        int lastWeight = (pq.size()>0) ?  pq.poll(): 0;
        return lastWeight;
    }
}