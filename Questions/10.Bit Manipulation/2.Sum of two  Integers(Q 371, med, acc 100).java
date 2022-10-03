class Solution {
    public int getSum(int a, int b) {
        
        while(b!=0){
       
        int carry = a & b ; // this is the number where the bits in a and b was 1
           // sum of the unmatched bits 
            a = a ^ b ; // xor operator 
          
            
        // but for carry to be optimized it should be added in the next bit so we have to shift the
      // number by left shift by 1 and update this value in b 
            
        b = carry << 1 ; 
        }
        
        return a ; 
    }
}