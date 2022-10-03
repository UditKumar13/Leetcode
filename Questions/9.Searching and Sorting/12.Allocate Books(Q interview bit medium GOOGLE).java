public class Solution {


    public boolean allocationPossible(ArrayList<Integer> A , int pages, int students){
        int curr_allocated = 0;
        int sum_allocated = 0;

        for(int i=0; i<A.size();i++){
            if(sum_allocated + A.get(i) > pages){
                sum_allocated = A.get(i);
                curr_allocated ++;
                if (sum_allocated > pages) return false;
            }
            else{
                sum_allocated += A.get(i); 
            }
        }

        if(curr_allocated < students){
            return true;
        }
        return false;
    }
    public int books(ArrayList<Integer> A, int B) {
        if (B > A.size()) return -1; 
        int result  = -1;
        int low = A.get(0);
        int high = 0;
        for(int i=0; i< A.size(); i++){
            low = Math.min(low,A.get(i));
            high += A.get(i);
        }

        while(low <= high){
         int mid = (low + high) >> 1;
         if (allocationPossible(A,mid,B)){
           result = mid ;
           high = mid - 1;
         }
         else {
             low = mid + 1;
         }
        }
        return result ; 
    }
}
