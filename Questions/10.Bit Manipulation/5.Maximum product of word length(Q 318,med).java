class Solution {
    public int maxProduct(String[] words) {
        int [] states = new int [words.length];
        int len = words.length;
        for(int i=0;i<words.length;i++){
            String curr = words[i];
            states[i] = filltheStates(curr);
        }
        
        // O(n2)
        
        int maxPro = 0;
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if((states[i] & states[j]) == 0){
                    int num = words[i].length() * words[j].length();
                    if(num > maxPro) maxPro = num;
                }
            }
        }
        return maxPro;
        
    }
    
    public int filltheStates(String s){
        int state = 0;
        for(char c : s.toCharArray()){
            int index = c - 'a';
            state |= 1 << (index); // shifting the bits 
        }
        
        return state;
    }
}


// state optimized solution

// TC : O(n**2)
// SC : O(n)