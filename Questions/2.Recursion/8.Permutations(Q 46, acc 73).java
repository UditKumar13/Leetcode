class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>() ; 
        
        permu(ans , nums, new ArrayList<>(), new boolean [nums.length]) ; 
        return ans ; 
        
    }
    
    
    public void permu(List<List<Integer>> ans , int [] nums , List<Integer> li , boolean [] used) {
        
        if (li.size() == nums.length ){
            ans.add(new ArrayList<>(li) ) ; 
        }
        
        
        else {
            
          for(int i = 0 ; i< nums.length ; i++){
              
              if (used[i]) continue ;
              
              else {
                  
                  li.add(nums[i]);
                  
                  used[i] = true ; 
                  
                  // recursion call 
                  
                  permu(ans, nums, li, used) ;
                  
                  // backtrack 
                  
                  used[i] = false  ;
                  
                  
                  // remove 
                  
                  li.remove(li.size()-1);
              }
          }
            
            
        }
        
        
    } 
    
}