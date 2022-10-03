// TC : O(nlogn)

// SC : O(n)
public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        
        ArrayList<Integer>nSE = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        st.push(A.get(0));
        nSE.add(-1);
        for(int idx=1; idx<A.size();idx++){
            int currEle = A.get(idx);
            while(!st.isEmpty() && st.peek() >= currEle) st.pop();
            nSE.add(st.isEmpty() ? -1: st.peek());
            st.add(currEle);
        }
        return nSE;
    }
}