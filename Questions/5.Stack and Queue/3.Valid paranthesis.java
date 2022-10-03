class Solution {
    public boolean isValid(String s) {
        
        
        Stack <Character> st = new Stack <>() ;
        
        
        int len = s.length() ; 
        
        for (int i =0 ; i<len ; i++){
            char ch  = s.charAt(i);
         if (ch == '(' || ch == '['  || ch == '{'){
             
             st.push (ch) ;
         }
            
            else{
                
                if (st.size()  > 0 ){
                     if (ch ==  ')' ){
                    if (st.peek() == '('){
                        st.pop() ; 
                    }
                    
                    else {
                        return false ; 
                     }
                }
                
                else if (ch == ']'){
             if (st.peek() == '['){
                        st.pop() ; 
                    }
                    
                    else {
                        return false ; 
                     }
                }
                
                else {
                  if (st.peek() == '{'){
                        st.pop() ; 
                    }
                    
                    else {
                        return false ; 
                     }
                }
                }
                
                
                else {
                  st.push(ch);
                }    // I was missing this case where I was missing what if for the very first time I get a ] or  } or ) 
               
            }
            
        }
        
        if (st.size() == 0){
            return true ; 
        }
        
        else {
            return false ; 
        }
    }
}