class Solution {
    
    public void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
    public int[] sortArrayByParity(int[] nums) {
        
        int  l=0,r = nums.length-1;
        while(l<r){
            int first = nums[l] % 2;
            if(first == 0) {
                //even
                l++;
                continue;
            }
            
            else {
                // odd
                if(nums[r] % 2 == 0 ){
                    swap(nums,l,r);
                    l++;
                    r--;
                }
                
                else {
                    r--;
                }
            }
        }
        return nums;
    }
}



// better solution 
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }