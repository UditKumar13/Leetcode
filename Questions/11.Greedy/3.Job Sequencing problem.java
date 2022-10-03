// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends

class cm implements Comparator<Job> {
    
    @Override
    public int compare(Job a , Job b){
        if (a.deadline > b.deadline && a.profit >= b.profit){
            return 1 ; 
        }
        
        else if(a.deadline < b.deadline && a.profit > b.profit){
            return -1 ; 
        }
        
        else if(a.deadline > b.deadline && a.profit < b.profit){
            return 1 ; 
        }
        
        else {
            return -1 ; 
        }
        
        
    }
}
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
      // sorting 
      Arrays.sort(arr, (a,b) -> b.profit-a.profit) ;
      // decreasing order of the profit greedy 
      
      int max_Dead = 0 ;
      for (int i=0; i<n ; i++){
          if (arr[i].deadline > max_Dead){
              max_Dead = arr[i].deadline ; 
          }
      }
      
      int [] result = new int [max_Dead+1] ;
      
      for (int k=1; k<=max_Dead; k++){
          result[k] = -1 ; 
      }
      
      int count = 0 , sum = 0 ; 
      for (int i=0;i<n;i++){
          
          for (int j=arr[i].deadline ; j>=1;j--){
              if (result[j] == -1){
                  result[j] = i ; 
                  count ++ ; 
                  sum += arr[i].profit ; 
                  break ; 
              }
          }
      }
      
      
      int ans [] = new int [2];
      
      ans[0] = count ; 
      ans[1] = sum ; 
      return ans ; 
      
    }
}