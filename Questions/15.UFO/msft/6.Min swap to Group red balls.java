class Solution {
    public static int minSwaps(String s) {
        List<Integer> rCount = new ArrayList<Integer>();
        int minSwap = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'R') {
             rCount.add(i);   
            }
        }
        int size = rCount.size(), mid = size/2;
        for(int i=0;i<rCount.size();i++){
            minSwap += Math.abs(rCount.get(mid) - rCount.get(i)) - Math.abs(mid - i);
            if(minSwap > 1e9) {
             minSwap = -1;
                break;
            }
        }
        return minSwap;
    }