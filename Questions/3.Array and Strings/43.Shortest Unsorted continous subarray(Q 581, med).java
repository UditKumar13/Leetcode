// TC O(nlogn) // SC O(n)

class Solution {
    public int findUnsortedSubarray(int[] nums) {
    int len = nums.length;
    int [] arr = new int [len];
    
    for(int i=0;i<len;i++){
        arr[i] = nums[i];
    }
        
   Arrays.sort(nums);
   int f=0,l=-1;
   int ff = 0, fl = 0;  
  for(int i=0,j=nums.length-1;i<len;i++,j--){
      if(ff == 0 && arr[i] != nums[i]) {
          ff =1;
          f = i;
      }
      
      if(fl == 0 && arr[j] != nums[j]){
          fl = 1;
          l = j;
      }
  }
        
int shortestLength = l - f +1;
        return shortestLength;
        
        
    }
}