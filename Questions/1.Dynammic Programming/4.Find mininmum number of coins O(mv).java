// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;


class Solution{
  
  
  public static int minCoins(int [] coins, int m , int V){
    
    // O(mv) using dp 
    
    int [] dp = new int [V+1] ;
    
    dp[0] = 0 ;
    
    for(int i =1 ; i<=V;i++){
      dp[i] = Integer.MAX_VALUE  ; 
    }
    
    
    for(int i = 1; i<=V; i++){
      
      for (int j = 0 ; j<m ; j++){
       
        if (coins[j] <= i){
        int cur_res = dp[i-coins[j]] ;
           
          if (cur_res != Integer.MAX_VALUE && cur_res + 1 < dp[i]){
            dp[i] = cur_res + 1 ; 
          }
        }
      }
    }
    if (dp[V] == Intger.MAX_VALUE) return -1 ; 
    return dp[V] ; 
  }
  
   public static void main (String[] args) 
    {
        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println ( "Minimum coins required is "
                            + minCoins(coins, m, V));
    }
  }
}