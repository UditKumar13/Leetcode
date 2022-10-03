public class Solution {
    // you need to treat n as an unsigned value
    
    public int hammingWeight(int n) {
        int nob = 0, num = n;
        while(num != 0){
            int mask = num & (-num); // right most set bit
            num = num - mask; // subtracting the mask 
            nob++;
        }
        
        return nob;
    
    }
}

// O(k) where k is the number of set bits 
