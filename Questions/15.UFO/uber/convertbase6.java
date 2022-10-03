import java.io.*;
import java.util.*;

public class Main {

    public static void convertToBase6(String str){
        int decimal = 0;

        for(int len =0;len<str.length();len++){
            decimal = decimal*2 + (str.charAt(len) - '0');
        }
        ArrayList<Integer> li = new ArrayList<Integer>();
        while(decimal>0){
            li.add(decimal % 6);
            decimal /= 6;
        }

        for(int i=li.size()-1;i>=0;i--){
            System.out.print(li.get(i) + "");
        }
    }
    public static void main(String args[]) {
        convertToBase6("100101");
    }
}