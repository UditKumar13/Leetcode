class Solution {
      public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums); // sorting ke liye 
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),nums,0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos) {
        res.add(new ArrayList<>(ls));
        for(int i=pos;i<nums.length;i++) {
            
            
           if(i>pos&&nums[i]==nums[i-1]) continue; // backtracking krte waqt 122 case mein [12 pos 0,1 ] [12 pos 0,2] naa aaye  
             ls.add(nums[i]);
            helper(res,ls,nums,i+1);     
            ls.remove(ls.size()-1);
        }
    }
    
    
}