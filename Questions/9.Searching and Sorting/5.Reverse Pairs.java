class Solution {
  
    int ans = 0 ; 
    public int reversePairs(int[] arr) {
       return mergeSort(arr,0,arr.length-1) ;
    }
  
  public  int  mergeSort(int [] arr, int s, int e){
    if (s>=e) return 0 ;
    
    int mid = s + (e-s)/2 ; 
    
    int ans = mergeSort(arr,s,mid) + mergeSort(arr,mid+1,e) ;
    
    for(int i = s, j = mid+1; i<=mid; i++){
      while(j<=e && arr[i]/2.0 >arr[j] ){
        j++; 
      }
      
      ans += j - (mid+1);
      
      
    }
    
    Arrays.sort(arr,s,e+1); // because the last index to be sorted is exclusive
    
    return ans ; 
  }
}