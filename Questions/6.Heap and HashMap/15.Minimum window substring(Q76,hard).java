class Solution {
    public String minWindow(String s, String t) {
        String minString = "";
        HashMap <Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        HashMap <Character,Integer> map1 = new HashMap<>();
        int currCount = 0, maxCount = t.length();
        int i=-1, j=-1;
        while(true){
            boolean f1 = false, f2 = false;
            // acquire 
            while(i<s.length()-1 && currCount < maxCount){
                i++;
                char ch = s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                if(map1.getOrDefault(ch,0)  <= map2.getOrDefault(ch,0)) currCount++;
                f1 = true;
            }
            
            
            // collect and release 
            while(j<i && currCount == maxCount){
             
                String pans = s.substring(j+1,i+1);
                if(minString.length() == 0 || pans.length() < minString.length()){
                    minString = pans;
                }
                j++;
                char ch = s.charAt(j);
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                }else{
                    map1.put(ch,map1.get(ch)-1);
                }
                
                if(map1.getOrDefault(ch,0) < map2.getOrDefault(ch,0)){
                    currCount--;
                }
                f2 = true;
                
            }
            
            if(f1 == false && f2 == false) break;
            
        }
        
        return minString;
    }
}