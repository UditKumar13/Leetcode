class Solution {
    public boolean equalFrequency(String word) {
        int n = word.length();
        int []freq = new int[26];
        for(int i=0;i<n;i++){
            char c = word.charAt(i);
            freq[c - 'a']++;
        }
        for(int i=0;i<n;i++){
            char c = word.charAt(i);
            freq[c-'a']--;
            if(checkEqual(freq)){
               return true; 
            }
            // backtrack
            freq[c-'a']++;
        }
        
        return false;
    } 
    
    public boolean checkEqual(int []arr){
        int flag = 0;
        for(int i :arr){
            if(i==0) continue;
            else if(flag == 0){
                flag = i;
            }else if(i == flag){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}