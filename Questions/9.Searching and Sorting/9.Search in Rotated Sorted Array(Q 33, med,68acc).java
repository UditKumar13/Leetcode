TC O(logn)

SC O(1) 

class Solution {
 public int search(int[] arr, int target) {

     int low = 0;
     int high = arr.length-1;
     while(low <= high){
         int mid = low + ((high - low) >> 1);
         if(arr[mid] == target){
             return mid;
         }
         
         if(arr[low] <= arr[mid]){
             // the left side is sorted
             if(target >= arr[low] && target <= arr[mid]){
                 high = mid-1;
             }
             
             else{
                 low = mid+1;
             }
         }
         
         else {
             // in the right side 
             if(arr[mid] <= target && target<=arr[high]){
                 low = mid + 1;
             }
             
             else{
                 high = mid - 1;
             }
         }
     }
     
     return -1;
     
    }
  
}