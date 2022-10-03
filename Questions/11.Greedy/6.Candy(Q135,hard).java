class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len <=1) return len;
        int prevSlope = 0, up = 0, down = 0, candies = 0;
        
        for(int i=1;i<len;i++){
            int currSlope = (ratings[i] > ratings[i-1]) ? 1: (ratings[i] <ratings[i-1]) ? -1: 0;
            
            //        _
            // \/ \_ /     3 cases where u have to calculate 
            if(prevSlope <0 && currSlope >=0 || (prevSlope >0 && currSlope ==0)){
                candies += sum(up) + sum(down) + Math.max(down,up);
                up = 0;
                down = 0;
            }
            
            if(currSlope >0) up++;
            else if(currSlope <0) down++;
            else candies++;
            prevSlope = currSlope;
        }
        candies += sum(up) + sum(down) + Math.max(down,up) + 1;
        return candies;
    }
    
    public int sum(int n){
        return (n)*(n+1)/2;
    }
}