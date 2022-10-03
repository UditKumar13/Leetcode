class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        
      HashSet <List<Integer>> res = new HashSet<>() ; 
      if (arr.length == 0 ) return new ArrayList<>(res) ; // base case 
      
      // sorting 
      Arrays.sort(arr) ;
      
      // 2 pointer approach 
      for(int  i =0 ; i<arr.length -2 ; i++){
        
        int  j = i +1 ; 
        int k  = arr.length -1 ; 
        
        while(j<k){
          
          int sum = arr[i] + arr[j] + arr[k] ;
          
          if(sum==0) res.add(Arrays.asList(arr[i], arr[j++], arr[k--]) );
          
          else if(sum>0) k-- ;
          
          else if(sum<0)j++ ; 
          
        }
      }
      
      return new ArrayList<>(res) ; 
      
    }
}