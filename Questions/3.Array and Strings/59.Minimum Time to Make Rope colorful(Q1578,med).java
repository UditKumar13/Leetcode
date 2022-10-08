
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost = 0;
        int n = colors.length();
        for(int i=1;i<n;i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                cost += Math.min(neededTime[i-1],neededTime[i]);
                neededTime[i] = Math.max(neededTime[i-1],neededTime[i]);
            }
        }
        return cost;

        
    }
}