Approach 1 :

TC : O(n)
SC : O(n) we have used the stack 

class Solution {
    public int longestValidParentheses(String s) {
        Stack <Integer> st = new Stack<>();
        int max = 0;
        st.push(-1);
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            
            else {
                st.pop();
                if(st.isEmpty()) st.push(i);
                else {
                    int len = i - st.peek();
                    max = Math.max(max,len);
                }
            }
        }
        
        return max;
    }
}


Approach 2 :

TC : O(n)
SC : O(n)

class Solution {
    public int longestValidParentheses(String s) {
       
        int open = 0, close = 0;
        int max =0;
        
        // 0 ... n-1
        int size= s.length();
        for(int i=0;i<size;i++){
            char ch = s.charAt(i);
            if(ch == '(') open ++;
            else close++;
            
            if(open == close) {
            int len = open + close;
            max = Math.max(max,len);
            }
            
            else if(close > open) open = close = 0;
            
        }
        
        open = close = 0;
        
        // n-1 .. 0 
        for(int j=size-1;j>=0;j--){
            char ch = s.charAt(j);
            if(ch == '(') open ++;
            else close++;
            
            if(open == close) {
            int len = open + close;
            max = Math.max(max,len);
            }
            
            else if(open > close) open = close = 0;
            
        }
        
        return max;
        
    }
}



// 
APPROACH 3 

DP 
