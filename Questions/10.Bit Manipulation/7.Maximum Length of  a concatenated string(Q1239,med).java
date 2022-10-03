class Solution {
    public int maxLength(List<String> arr) {
        List<String> ansList = new ArrayList<>();
        int maxLen = 0;
        ansList.add("");
        
        for(String str : arr){
            if(!checkUnique(str)) continue;
            List<String> newAnsList = new ArrayList<>();
            for(String candidate : ansList){
                String temp = candidate + str;
                if(checkUnique(temp)){
                    newAnsList.add(temp);
                    maxLen = Math.max(maxLen,temp.length());
                }
            }
            ansList.addAll(newAnsList); // addALL first usuage 
        }
        return maxLen;
    }
    
    public boolean checkUnique(String str){
        if(str.length() > 26) return false;
        int[] freq = new int[26];
        char[] arr = str.toCharArray();
        for(char ch : arr){
            freq[ch-'a']++;
            if(freq[ch-'a'] > 1)return false;
        }
        return true;
    }
}