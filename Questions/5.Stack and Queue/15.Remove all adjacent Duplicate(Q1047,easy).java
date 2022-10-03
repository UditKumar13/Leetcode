class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<Character>();
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek().equals(ch)){
                st.pop();
            }
            
            else{
                st.push(ch);
                
            }
            
        }
        
        char [] arr = new char[st.size()];
      
        int idx =0;
        while(st.size()>0){
            arr[idx] = st.pop();
            idx++;
        }
        
         String removeDuplicate = String.valueOf(arr);
         return removeDuplicate;
    }
}