class Solution {
    public int[][] merge(int[][] arr) {
        
      
     if(arr.length <= 1)
       return arr ; 
      
      // sorting the array with the asceanding starting point
      
      // O(nlogn)
      
      Arrays.sort(arr, (a,b) -> a[0]- b[0]); 
      
      List <int []> ans = new ArrayList<>() ; 
      
      int start = arr[0][0]; 
      int end = arr[0][1]; 
      int i =1 ; 
      
      while(i < arr.length){
        
        
        int s = arr[i][0] ; 
        int e = arr[i][1] ; 
        if(s <= end){
          // overlapping this means we have to update the end
          end = Math.max(end,e);
          
          
        }
        
        else{// disjoint so add before it
          
          ans.add(new int[] {start,end});
          start = s ; 
          end = e ; 
        }
        
        i++ ; 
      }
      
      ans.add(new int[] {start,end}) ; 
      
      return ans.toArray(new int [0][]) ; 
    }
}