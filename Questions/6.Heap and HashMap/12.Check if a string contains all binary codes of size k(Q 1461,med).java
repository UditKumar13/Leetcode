class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet <String> set = new HashSet<>();
        int n = s.length(), ws = k;
        for(int i=0; i<n-ws+1; i++){
            String curr = s.substring(i,i+k);
            set.add(curr);
        }
        
        int totalSets  = (int)Math.pow(2,k);
        return totalSets == set.size() ? true: false;
    }
}