class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       // brute force is n^2
      // elaborate more: 
      int min_length = 0;
      int curr_sum = 0;
      Queue<Integer> q = new LinkedList<Integer>();
      for(int i=0; i<nums.length; i++){
        q.add(nums[i]);
        curr_sum += nums[i];
        while(curr_sum >= target){
          if(min_length == 0) min_length = q.size();
          else min_length = Math.min(min_length, q.size());
          curr_sum -= q.poll();
        }
      }
      return min_length;
    }
}


import java.util.*;
import java.io.*;

public class Main {

  public static int minSizeSubArray(int[] arr, int target){
    int left = 0;
    int windowSum = 0;
    int minSize = Integer.MAX_VALUE;

    for (int right=0; right < arr.length; right++){
      windowSum += arr[right];

      // shrink window 
      while (windowSum >= target){
        minSize = Math.min(minSize, right - left + 1);
        windowSum -= arr[left];
        left++;
      }
    }
    return (minSize == Integer.MAX_VALUE) ? 0: minSize;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    int[] arr = new int[n];
    for (int i=0; i<n; i++){
      arr[i] = sc.nextInt();
    }
    for (int i=0; i<n; i++){
      System.out.println(arr[i]);
    }
    System.out.println("Enter value for the target:");
    int target = sc.nextInt();
    int mss = minSizeSubArray(arr, target);
    System.out.println("min size subaaray for array arr is %d:" + mss);
  }
}

/*

in go syntax  :

func minSubArrayLen(target int, nums []int) int {

// using sliding window

    left := 0
    windowSum := 0
    minSize := math.MaxInt32

    for right := 0; right < len(nums); right++ {
        windowSum += nums[right]

        // shrink window 
        for windowSum >= target {
            minSize = int(math.Min(float64(minSize), float64(right - left + 1)))
            windowSum -= nums[left]
            left++
        }
    }

    if minSize == math.MaxInt32 {
        return 0
    }
    return minSize
}

*/