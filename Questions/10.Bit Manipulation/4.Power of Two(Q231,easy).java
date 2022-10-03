class Solution {
    public boolean isPowerOfTwo(int n) {
        
        int count = 0;
        int num = n;
        if(n == Integer.MIN_VALUE || n == Integer.MAX_VALUE) return false;
        while (num != 0){
            int mask = num & (-num);
            num -= mask;
            count++;
        }
        
        return count == 1 ? true : false;
    }
}