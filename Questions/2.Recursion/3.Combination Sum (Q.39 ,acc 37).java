class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        
        
        List<List<Integer>> ans = new ArrayList<>() ;
        
        Arrays.sort(candidates) ; 
        
        recursion(0, ans, new ArrayList<>(), target,candidates) ; 
        
        return ans ; 
        
        
    }
    
    
    public void recursion(int start, List<List<Integer>> ans, List<Integer> li, int remain, int [] arr){
   // remain is the target
        
        if (remain < 0){
            return ; 
        }
        
        else if(remain == 0){
            ans.add(new ArrayList<>(li));
        }
        
        else{
            
            for(int i = start; i<arr.length ; i++){
                
                
                li.add(arr[i]);
                recursion(i,ans,li,remain-arr[i],arr); // not i+1 because we can use the same element remember 
                
                li.remove(li.size()-1);
            }
            
        }
        
        
    }
}