import java.io.*;
import java.util.*;

public class Main {

    public static boolean isCowPlaced(int []arr,int cows,int gap, int n){
        int count =1;
        int lastPlacedCow = arr[0];

        for(int i =1; i<n;i++){
            if (arr[i] - lastPlacedCow >= gap){
                count++;
                lastPlacedCow = arr[i];

            }
        }

        if(count >= cows) return true;
        return false;
    }
    public static int greatestofMinimum(int []arr, int n, int c){
        int len = arr.length-1;
        int low = 1;
        int high = arr[len-1] - arr[0];
        Arrays.sort(arr);
        while(low <= high){
            int gap = (low + high) >> 1;
            if (isCowPlaced(arr,c,gap,n)){
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return high;
    }
    public static void main(String args[]) {
      iScanner scn = new Scanner (System.in);
      int test = scn.nextInt();

      for (int i=0;i<test;i++){
          int no_Stalls = scn.nextInt();
          int cows = scn.nextInt();
          int [] arr = new int [no_Stalls];
          int greatestofMinimum = aggresiveCows(arr,no_Stalls,cows);
          System.out.println(greatestofMinimum);
      }

    }
}