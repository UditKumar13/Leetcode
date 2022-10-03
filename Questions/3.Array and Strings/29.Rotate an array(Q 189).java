
TC O(n) SC O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length ;
        
        if(k<0) k = k + nums.length;
        int len = nums.length;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
        print(nums);
    }
    
    public void reverse(int [] nums, int i, int j){
      while(i<j){
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
          i++;
          j--;
      }
    }
    
    public void print(int [] arr){
        for(int num : arr){
            System.out.println(num);
        }
    }
}