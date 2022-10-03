class Solution {
  public int[] gardenNoAdj(int n, int[][] paths) {
    int [] ans = new int [n] ;
      
      Arrays.fill(ans,1) ;
      boolean stop = false ; 
     do{
          stop = true  ;
      
      for(int [] edge : paths){
          int u = Math.min(edge[0], edge[1]) ;
          int v = Math.max(edge[0], edge[1]) ; 
          
          
          if (ans[u-1] == ans[v-1]){
              stop = false ; 
              
              ans[v-1] = ans[v-1] == 4 ? 1 : ans[v-1] + 1 ; 
          }
          
          
      }
     }while(!stop) ;
   
      return ans ; 
      
    }
}