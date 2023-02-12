class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> s = new HashSet<String>();
        List<String> li = new ArrayList<>();
        for(String w : words){
            s.add(w);
        }
        for(String w : words){
            if(checkConcatenate(w,s) == true) li.add(w);
        }
        return li;
        
    }
    
    public boolean checkConcatenate(String w, Set<String> s){
        for(int i=1;i<w.length();i++){
            String prefix = w.substring(0,i);
            String suffix = w.substring(i,w.length());
            if(s.contains(prefix) && (s.contains(suffix) || (checkConcatenate(suffix,s)))){
                return true;
            }
        }
        
        return false;
        
    }
}