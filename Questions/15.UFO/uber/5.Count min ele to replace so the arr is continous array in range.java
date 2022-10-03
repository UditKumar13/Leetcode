import java.io.*;
import java.util.*;

/*

You can replace any integer of the array with an integer.
Your task is to print the minimum operations required to make the elements continuous.

Constraints: 1 <= N <= 1e6, 1 <= A[i] <= 1e9

Input: 4 7 11 6 9
Output: 2
*/
public class Main { 
    public static void main(String args[]) {
        int arr[]=new int[]{4,7,11,6,9};
        Arrays.sort(arr);
        int len = arr.length;
        int min = len;
        for(int i=0;i<len;i++){
            int search = arr[i] + len -1;
            int lower_bound = getlowerBound(arr,search);
            int continuousElements = len - lower_bound;
            if(len - continuousElements < min) min = len - continuousElements;
        }
        System.out.println(min);
    }

    public static int getlowerBound(int[]arr, int ele){
        int st =0, end = arr.length-1;
        while(st <= end){
            int mid = (end - st)/2 + st;
            if(arr[mid] == ele) return mid;
            else if(arr[mid] < ele){
                st = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return st - 1;
    }
}