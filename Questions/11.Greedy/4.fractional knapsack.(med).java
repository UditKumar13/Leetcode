// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class itemComparator implements Comparator<Item>{
    
    @Override
    public int compare(Item a, Item b){
        
        double r1 = (double)a.value/(double)a.weight ;
        double r2 =  (double)b.value/(double)b.weight ;
        
        if (r1 < r2) return 1 ; 
        else if (r1 > r2) return -1  ;
        else return -1 ; 
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        
     Arrays.sort(arr,new itemComparator()) ;
     
     // sort in the descending order of ratio of value to 
     int curr_weight = 0 ;
     
     double ans = 0.0 ;
     
     for(int i =0 ; i<n; i++){
         if(curr_weight + arr[i].weight <= W){
             curr_weight += arr[i].weight ;
             ans += arr[i].value;
         }
    
         else{
             int rem =W-curr_weight;
             ans += ((double)arr[i].value / (double)arr[i].weight) * (double)rem;
             break ; 
             
         }
     }
     
     return ans ; 
     
    }
}