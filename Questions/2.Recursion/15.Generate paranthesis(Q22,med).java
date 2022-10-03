class Solution {
   public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<String>();
        helper(ans,n,0,0,"");
        return ans;
    }
    
    public void helper(List<String> ans,int n,int openCount,int closeCount,String s){
        
        if(openCount==n && closeCount==n){
            ans.add(s);
            return;
        }
        if(openCount<n){
             helper(ans,n,openCount+1,closeCount,s+"(");
        }
         if(closeCount<openCount){
             helper(ans,n,openCount,closeCount+1,s+")");
        }
    }
}