
class Solution {
    
    public boolean compare(HashMap <Character,Integer> map1,HashMap <Character,Integer> map2 ){
        if(map1.equals(map2) == true) return true;
        return false;
    }
    public boolean isAnagram(String s, String t) {
        HashMap <Character,Integer> map = new HashMap<>();
        HashMap <Character,Integer> map2 = new HashMap<>();
        int m = s.length(), n = t.length();
        if(m != n) return false;
        for(int i=0;i<m;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                int of = map.get(ch);
                of += 1;
                map.put(ch,of);
            }
            else {
                map.put(ch,1); 
            }
           
        }
        
        for(int i=0;i<n;i++){
            char curr = t.charAt(i);
            if(map2.containsKey(curr)){
                int of = map2.get(curr);
                of += 1;
                map2.put(curr,of);
            }
            else {
                 map2.put(curr,1); 
            }
          
        }
        
        // now compare  the 2 hashmap 
        boolean va = compare(map,map2);
        return va;
    }
}