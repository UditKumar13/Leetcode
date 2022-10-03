
// Brute Force 
TC 0(n*mlog(n*m))
public class Solution {
    public int findMedian(int[][] A) {

        int n = A.length ; 
        int m = A[0].length ; 
         int [] farr = new int [n*m] ;
        int c = 0 ; 
        for (int i =0 ; i< n ; i++){ 
             for(int j = 0;j<m ; j++){
                farr[c]  = A[i][j] ;
                c++ ;  
             }
        }

        // array has been filled

        Arrays.sort(farr) ;
        int ans =  0 ; 
        int num = farr.length ; 
        ans = num / 2 ;
        return farr[ans] ; 



    }

}


// OPtimized Solution using Binary search

TC O(32 * N  * log M)

public class Solution {
    private int countSmallerThanMid(ArrayList<Integer> row, int mid) {
        int l = 0, h = row.size() - 1; 
        while(l <= h) {
            int md = (l + h) >> 1; 
            if(row.get(md) <= mid) {
                l = md + 1;
            }
            else {
                h = md - 1;
            }
        }
        return l; 
    }
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE; 
        int n = A.size();
        int m = A.get(0).size(); 
        while(low <= high) {
            int mid = (low + high) >> 1; 
            int cnt = 0;
            for(int i = 0;i<n;i++) {
                cnt += countSmallerThanMid(A.get(i), mid); 
            }
    
            if(cnt <= (n * m) / 2) low = mid + 1; 
            else high = mid - 1; 
        }
        return low; 
    }
}
