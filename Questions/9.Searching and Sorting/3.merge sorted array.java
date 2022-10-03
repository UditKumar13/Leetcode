// 10 min 

class Solution {
    public int [] merge(int[] nums1, int m, int[] nums2, int n) {
        
      // we have to implemnt the merge 
      
      
      // this is the fastest and clean java code of merge 
      
    int tail1 = m-1, tail2 = n-1  ;
    int finished = m+n-1 ; 
   while(tail1 >= 0 && tail2 >=0){
     nums1[finished--] = nums1[tail1]>=nums2[tail2] ? nums1[tail1--]:nums2[tail2--] ; 
   }
       
      
      while(tail2 >=0 ){
        nums1[finished--] = nums2[tail2--] ; 
      }
      return nums1 ; 
    }
}