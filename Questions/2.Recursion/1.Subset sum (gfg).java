// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
  ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
    ArrayList <Integer> sub_Sum = new ArrayList<>() ; 
      func(0,0,arr,N,sub_Sum) ; 
      Collections.sort(sub_Sum) ; 
      return  sub_Sum; 
    }
  
  
  void func(int idx,int sum , ArrayList<Integer> arr, int N, ArrayList<Integer> subset_Sum){
      
      if (idx == N){
          subset_Sum.add(sum) ; 
          // do something 
          return  ; 
      }
      
      // take a number into the consideration and update the sum 
      
      func(idx +1 , sum + arr.get(idx) , arr, N, subset_Sum) ;
      
      // leave the number and search further 
      
      func(idx + 1, sum , arr, N, subset_Sum) ;
      
      
      
      
  }
 
 
 
    }
