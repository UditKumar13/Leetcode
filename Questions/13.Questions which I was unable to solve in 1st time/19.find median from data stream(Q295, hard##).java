class MedianFinder {
    PriorityQueue <Integer> maxHeap;
    PriorityQueue <Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b -a );
        minHeap = new PriorityQueue<>((a,b) -> a -b );
        
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        
        else 
            minHeap.add(num);
        
        // after checking we have to make the cases where 
        // case 1 maxheap and  min heap should have the same size 
        // case 2 maxheap should have only size 1 greater than minHeap
        
        if(maxHeap.size() < minHeap.size() ){
            maxHeap.add(minHeap.poll());
        }
        
        else if(maxHeap.size() > minHeap.size() + 1 ){
            minHeap.add(maxHeap.poll());
        }
    }
    
  
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
        }
        return maxHeap.peek();
    }
}


// TC : Brute force TC : 0(n**2) 

// optimized 
// TC : O(n * logn)

// SC : O(n)


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */