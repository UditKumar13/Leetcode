import java.io.*;
import java.util.*;

public class Main {

    public static int maximumXor(int n,int l, int r){
        int x = 0;
        for(int i=(int)(Math.log(r)/Math.log(2)); i>=0; i--){
            if((n & (1<<i)) >0){
                // bit is set
                if(x + (1<<i) + 1 < l){
                    x ^= (1<<i);
                }
            }else{
                // bit is not set
                if((x ^(1<<i)) <=r){
                    x ^= (1<<i);
                }
            }
        }
        return n ^ x;
    }
    public static void main(String args[]) {
        int n = 2;
        int l=4;
        int r = 6;

        int ans = maximumXor(n,l,r);
        System.out.println(ans);
    }
}