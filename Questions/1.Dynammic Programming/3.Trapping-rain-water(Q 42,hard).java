

// Approach 1: Brute Force
// For each index i, find the max height on left and max height on right by iterating in both directions. Calculate water at that index using the formula.

// TC: O(n²) — for each element, scanning left and right
// SC: O(1)


// Approach 2: Prefix Max Arrays
// Precompute two arrays — leftMax[] (left to right pass) and rightMax[] (right to left pass). Then for each index, apply the formula directly.

// TC: O(n) — 3 passes (left, right, calculate)
// SC: O(n) — 2 extra arrays


// Approach 3: Two Pointer (Optimal)
// Use two pointers — left and right starting from both ends. Track leftMax and rightMax on the fly. Move the smaller side inward, because water is always determined by the shorter boundary.

// TC: O(n) — single pass
// SC: O(1) ✅





// Summary
// ApproachTCSCMethod1. Brute ForceO(n²)O(1)Har index pe left-right scan2. Prefix ArraysO(n)O(n)leftMax[] + rightMax[]
// 3. StackO(n)O(n)Monotonic decreasing stack4. Two PointerO(n)O(1) ✅left-right pointers

class Solution {

  // Prefix and Suffix Approach :
    // tc : O(n) — 3 passes
    // sc : O(n) — 2 extra arrays
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Step 1: leftMax banao
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Step 2: rightMax banao
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Step 3: water calculate karo
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }
}



class Solution {
    public int trap(int[] height) {
        
      // Best Aproach :
      // 1 pass solution using 2 pointer approach
      // this can be done in O(n) TC and O(1) SC
      
      int li = 0 , ri = height.length -1 , max_li = 0 , max_ri = 0, water = 0  ; 
      // visualize the problem only then you will understand the approach
      
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