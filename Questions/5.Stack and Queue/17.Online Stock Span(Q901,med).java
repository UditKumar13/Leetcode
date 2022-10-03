class Pair{
    int first;
    int second;
    
    Pair(int x, int y){
        this.first = x;
        this.second = y;
    }
}

class StockSpanner {
    Stack <Pair> st; // idx val 
    public int idx = -1;
    int first_time = 0;
    
    public StockSpanner() {
        st = new Stack<Pair>();
    }
    
    public int next(int price) {
       idx ++;
       int diff = 0;
       while(!st.isEmpty()){
           first_time = 1;
           if(price >= st.peek().second){
               st.pop();
           }
           else {
               int prev_idx = st.peek().first;
               diff = idx - prev_idx;
               break;
           }
       }
       
      if(first_time == 0){
          diff = 1;
        
      }
      else if (st.isEmpty() && first_time == 1){
          diff = idx + 1;
          
      }
      Pair pr = new Pair(idx,price);
      st.push(pr);
     return diff;   
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */