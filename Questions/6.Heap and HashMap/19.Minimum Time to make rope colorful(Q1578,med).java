class Pair{
    char ch;
    int num;
    Pair(char _ch, int _num){
        this.ch = _ch;
        this.num =_num;
    }
}
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost = 0,n = colors.length();
        if(n == 0 || n==1) return 0;
        Stack <Pair> st = new Stack<Pair>();
        for(int i=0;i<n;i++){
            char cur = colors.charAt(i);
            int no = neededTime[i];
            Pair p = new Pair(cur,no);
            st.push(p);
        }
        // we have pushed the pair
        
        while(st.size()>=2){
            Pair top = st.pop();
            Pair ntop = st.peek();
            char nch = ntop.ch;
            int val = ntop.num;
            if(nch==top.ch){
                if(top.num <= val){
                    // top ko hato 
                    cost += top.num;
                }else{
                    // pop the ntop
                    st.pop();
                    st.push(top);
                    cost += val;
                }
                
            }
        }
        
        return cost;
        
    }
}