class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        
          Arrays.sort(arr); // sorting
      
      // no need of using the hash 
      
      
     List<List<Integer>> res = new LinkedList<>() ; 
      
      for(int i =0 ; i<arr.length-2 ; i++){
        // condition to avoid duplicates   
        if(i == 0 || (i>0 && arr[i] != arr[i-1])){
          
          int lo = i+1, hi = arr.length-1, sum = - arr[i] ; 
          
          while(lo < hi ){
            if(arr[lo] + arr[hi] == sum){
              res.add(Arrays.asList(arr[i], arr[lo],arr[hi]));
              
              // conditions to avoid duplicates 
              while((lo < hi) && arr[lo] == arr[lo+1] ) lo++ ;
              while((lo < hi) && arr[hi] == arr[hi-1] ) hi-- ;
              
              lo++ ;
              hi-- ; 
            }
            
            else if(arr[lo] + arr[hi] > sum){
              hi-- ; 
            }
            
            
            else{
              lo++ ; 
            }
          }
        }
      }
        return res ; 
      }
}