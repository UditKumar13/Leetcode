


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map <Integer,Integer> map = new HashMap<>();
       for(int num:nums){
           map.put(num,map.getOrDefault(num,0)+1);
       }
       PriorityQueue <Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b)-> (b.getValue() -a.getValue()));
       // for the maxHeap property b.getValue() - a.getValue()
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            maxHeap.add(entry);
        }
        
        int [] topK = new int [k];
        int idx =0 ;
        while(idx<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            topK[idx]=entry.getKey();
            idx++;
        }
        return topK;
        
    }
}