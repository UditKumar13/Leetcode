class Solution {
    public int[] twoSum(int[] num, int target) {
        
        int low = 0, hi = num.length-1;
        int []indices = new int[2];
        while(low < hi){
            if(num[low] + num[hi] > target){
                hi--;
            }else if(num[low] + num[hi] < target){
                low++;
            }else {
                indices[0] = low+1;
                indices[1] = hi+1;
                break;
            }
        }
        
        return indices;
    }
}


// TC : O(n)


// Approach 2 :


