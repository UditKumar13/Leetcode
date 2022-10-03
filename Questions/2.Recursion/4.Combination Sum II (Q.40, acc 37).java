class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        
        
     List<List<Integer>> ans = new ArrayList<>() ;
        
    Arrays.sort(nums) ;  // for resolving 1-4 and 4-1 case 
    
   recursion(0, ans, new ArrayList<>() , nums, target) ; 
    return ans ; 
    }
    
    
    public void recursion(int start, List<List<Integer>> ans, List<Integer> li, int [] nums, int remain ){
       
        
        if (remain < 0){
            return ; 
        }
        
        
        else if (remain == 0 ){
            ans.add(new ArrayList<>(li));
        }
        
        
        else {
            
            for(int i = start ; i<nums.length; i++){
                if (i > start && nums[i]==nums[i-1]) continue ; // for removing the duplicates 
                
                li.add(nums[i]) ;
                recursion(i+1, ans,li,nums,remain-nums[i]); // i+1 because some number is not allowed
                li.remove(li.size()-1);
                
                
            }
            
        }
    }
}