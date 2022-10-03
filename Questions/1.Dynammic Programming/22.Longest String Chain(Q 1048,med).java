// Approach 1 : 

From StringBuilder 

class Solution {
    public int longestStrChain(String[] words) {
        int len = words.length;
        if(words == null || len == 0) return 0;
        
        HashMap <String,Integer> map = new HashMap<>();
        Arrays.sort(words,(a,b)-> a.length() - b.length());
        int longestChain = 0;
        for(String w : words){
           
            map.put(w,1);
            for(int i=0;i<w.length();i++){
                StringBuilder sb = new StringBuilder(w);
                String next = sb.deleteCharAt(i).toString();
                
                
                if(map.containsKey(next) && map.get(next) + 1 > map.get(w)){
                    map.put(w,map.get(next) + 1);
                }
                
            }
            
            longestChain = Math.max(longestChain,map.get(w));
        }
        
        return longestChain;
    }
}