// google 
// Amazon 



class Solution {
  public List<List<Integer>> fourSum(int[] num, int target) {

    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    if (num == null || num.length ==0){
     return res ;  
    }
    
    int n = num.length ; 
    
    Arrays.sort(num) ; // takes nlogn
    
    for(int i =0 ; i<n ; i++){
      for(int  j = i+1 ; j<n; j++){
        
        int target_2 = target - num[i] - num[j] ;
        
        int front  = j+1;
        int back = n-1;
        
        while(front<back){
          int two_sum =  num[front] + num[back];
          if(two_sum < target_2){
            front++ ; 
          }
          
          else if(two_sum > target_2){
            back --;
          }
          
          else {
            // we have found a quadruplet
            List<Integer> quad = new ArrayList() ;
            
            quad.add(num[i]);
            quad.add(num[j]);
            quad.add(num[front]);
            quad.add(num[back]);
            res.add(quad);
            
            //processing the duplicates of the number 3 
            
            while(front < back && num[front] == quad.get(2)) ++front ;  
            // processing the duplicates of the number 4
            while(front < back && num[back] == quad.get(3)) -- back ; 
          }
        }
        
        // processing the duplicates of j loop
        while(j+1 < n && num[j] == num[j+1]) j++ ; 
      }
      // processing the duplicates of ith loop
          while(i+1 < n && num[i] == num[i+1]) i++ ; 
    }
    
    return res ; 
}
  
}