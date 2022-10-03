class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        permutations(ans, new ArrayList<>(), nums);
        return ans ; 
        
    }
    
    
    public void permutations(List<List<Integer>> ans, List<Integer> li, int [] nums){
        
        
        if (li.size() == nums.length ){
            ans.add(new ArrayList<>(li)); 
        }
        
        else {
            
            for(int i =0 ; i<nums.length ; i++){
                if (li.contains(nums[i])) continue ; // for removing the duplicates
                
                li.add(nums[i]);
                permutations(ans,li,nums);
                li.remove(li.size()-1);
            }
            
        }
    }
}