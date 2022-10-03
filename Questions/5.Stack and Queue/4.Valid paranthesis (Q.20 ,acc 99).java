class Solution {
    public boolean isValid(String s) {
        
        
        Stack <Character> st = new Stack <>() ;
        
        // we have to convert  a string to charArray for char access 
        
        for (char ch : s.toCharArray()){
            
           if (ch == '(') st.push(')') ; 
           else if (ch == '[') st.push(']') ; 
           else if (ch == '{') st.push('}') ; 
            
           else {
               if (st.isEmpty() || st.pop() != ch){
                   // yaa toh empty ho , yaa jo check hone waala hai bcz woh phle se hi anti matter hai aurr equal nhi hai toh return false ; 
                   return false ; // this is the case where we can't have the valid paranthesis
               }
           }
            
            
            
        }
        
        return st.isEmpty() ; 
       
        
    }
}