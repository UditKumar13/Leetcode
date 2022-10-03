class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i =1;
        int j = bits.length-1;
         if(j==0) {
                if(bits[0] == 0) return true;
            }
        while(i<=j){
           
            int curr = bits[i];
            int prev = bits[i-1];
            
            if (i==j) {
                if((bits[i-1] == 0) && (bits[i] == 0) ){
                    return true;
                }
            }  
            else if((curr == 1 && prev == 1) || (curr == 0 && prev == 1) ){
                bits[i-1] =0;
                bits[i] =0;
            }
            
            i++;
            
            }
        
            
        return false;
    }
}