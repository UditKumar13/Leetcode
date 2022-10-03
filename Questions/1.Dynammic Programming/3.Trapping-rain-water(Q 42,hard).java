class Solution {
    public int trap(int[] height) {
        
      
      
      // this can be done in O(n) TC and O(1) SC
      
      int li = 0 , ri = height.length -1 , max_li = 0 , max_ri = 0, water = 0  ; 
      
      
      while(li < ri){
        
        if (height[li] < height[ri]){
          // this means there is some big building on the right to our curr building 
          
          if(height[li] >= max_li){
            
            // if the max_left height of any building is shoter or equal than the curr building update the max_li
            max_li = height[li] ; 
            
          }
          
          else {
            // this means there is something on the right also on the left of this curr bulding that means, water can be added 
            water +=  max_li - height[li] ; // left max - curr building height 
          }
          
          // increment pointer 
          li ++ ; 
        }
        
        else {
          
          // that means now we will focus on the right part from the back side
          if(height[ri] >= max_ri ){
            max_ri = height[ri] ; 
          }
          
          
          else {
            // there is a big building on the right and also the big building on the left but the water can be maintained 
            // by the height which is Math.min(max_li,max_ri)  and here that factor is max_ri bcz it is smaller
            
            water +=  max_ri - height[ri]; 
          }
          
          ri-- ; // update the right pointer 
        }
      }
      
      return water ; 
    }
}