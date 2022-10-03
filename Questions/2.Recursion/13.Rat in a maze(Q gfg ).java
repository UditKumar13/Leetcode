// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
      
      ArrayList<String> ans = new ArrayList<String>() ;
      
      
      boolean [][] visited = new boolean [n][n]  ;
      
     
      if (m[0][0] == 1)solve(m,n,ans,0,0,visited, "") ; // 0  0 is the i and j index 
     if (ans.size()>=1){
         return ans ; 
     }
     
     else {
         ans.add("-1");
         return ans; 
     }
     
    }
    
    
    public static void solve(int [][] m , int n , ArrayList<String> ans , int i , int j , boolean [][] visited
    ,String str){
       
       if (i == n-1 && j==n-1 ){
           ans.add(str) ;
           
           return ; 
       }
       
       //  base case 
    
    
    // down 
    if (i+1<n && visited[i+1][j] == false  && m[i+1][j] ==1){
        visited[i][j] = true ; 
        
        solve(m,n, ans, i+1, j , visited, str+"D") ; 
        
        visited[i][j] = false ; 
    }
    
    // left 
    
        if (j-1>=0 && visited[i][j-1] == false  && m[i][j-1] ==1){
        visited[i][j] = true ; 
        
        solve(m,n, ans, i, j-1 , visited, str+"L") ; 
        
        visited[i][j] = false ; 
    }
    
    // right 
    
        if (j+1<n && visited[i][j+1] == false  && m[i][j+1] ==1){
        visited[i][j] = true ; 
        
        solve(m,n, ans, i, j+1 , visited, str+"R") ; 
        visited[i][j] = false ; 
    }
    
    // up 
           if (i-1>=0 && visited[i-1][j] == false  && m[i-1][j] ==1){
        visited[i][j] = true ; 
        
        solve(m,n, ans, i-1, j , visited, str+"U") ;
        
        visited[i][j] = false ; 
    }
    
    }
}