public class Solution {
    public int solve(int[] A, int B){
        
        HashMap <Integer, Integer> map = new HashMap <Integer, Integer>() ;

        int cnt = 0 ;
        int xor = 0 ; 

        int n = A.length ; 

        for(int i =0 ; i<n;i++){
         xor = xor ^ A[i] ;

         if(map.get(xor^B) != null){
             cnt += map.get(xor^B) ; 
         }

         if(xor == B){
         cnt++ ; 
         }

         if(map.get(xor) != null){
         map.put(xor,map.get(xor) + 1) ; 
         }

         else {
             map.put(xor,1) ; 
         }
        }
        return cnt ;  

    }
}
