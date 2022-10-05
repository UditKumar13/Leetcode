class Solution {
    public int minimizeXor(int num1, int num2) {
        int a = Integer.bitCount(num1),b = Integer.bitCount(num2);
        int res = num1;
        for(int i=0;i<32;i++){
            if(a>b && ((1<<i) & num1) >0){
                a--;
                res ^= (1<<i);
            }
            if(a<b && ((1<<i) & num1)==0){
                a++;
                res ^= (1<<i);
            }
        }
        return res;
    }
}