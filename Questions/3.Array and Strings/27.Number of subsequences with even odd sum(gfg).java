import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        int result = 0;
        int countOdd = 0, countEven =0;

        int [] arr ={1,2,2,3};
        
        for(int i=0;i<arr.length ; i++){

         int num = arr[i] ;
         if (num%2==0){
         countOdd = countOdd + countOdd ; // why second countOdd milkrr woh khud bhi odd hi bnayega
         countEven = countEven + countEven + 1 ; 
         }


         else{
              int temp = countEven;
         countEven =countEven + countOdd ;
         countOdd = countOdd + temp + 1 ;  // 1 is for the numbe itself 
         }
        }

        System.out.println("even subsequences sum : " + countEven);
        
        System.out.println("even subsequences sum : " + countOdd);

    }
}