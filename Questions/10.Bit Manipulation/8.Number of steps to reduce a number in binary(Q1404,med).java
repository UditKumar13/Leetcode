class Solution {
    public int numSteps(String s) {
        int carry = 0, res = 0;
        for(int i=s.length()-1;i>0;i--){
            res++;
            if(s.charAt(i) - '0' + carry == 1){
                carry = 1;
                res++;
            }
        }
        
        return carry + res;
    }
}