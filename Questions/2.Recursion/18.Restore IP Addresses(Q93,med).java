class Solution {
    List<String> ans = new ArrayList<>();
    String str;
    public List<String> restoreIpAddresses(String s) {
        str = s;
        recursion("",0,0);
        return ans;
    }
    
    public void recursion(String path, int index, int dots){
        if(dots > 4) return;
        if(dots == 4 && index>=str.length()){
            ans.add(path.substring(0,path.length()-1));
            return;
        }
        
        for(int length=1; length<=3 && index + length <= str.length(); length++ ){
            String num = str.substring(index, index + length);
            if(num.charAt(0) == '0' && length !=1) break; // cases for 012
            else if(Integer.parseInt(num) <=255){
                // recursion call 
                recursion(path + num + ".", index + length, dots+1);
            }
            
        }
    }
}