//'main' method must be in a class 'Rextester'.
//openjdk version '11.0.5' 

import java.util.*;
import java.lang.*;

class Rextester
{  
    public static int maximumK(String s){
        int N = s.length();
        int ans = N;
        boolean flag = false;
        for(int i=0;i<N-1;i++){
            if(s.charAt(i) != s.charAt(i+1)){
                flag= true;
                ans = Math.min(ans, Math.max(i+1, N - i - 1));
            }
        }

        if(flag == false) return 0;
        return ans;
    }
    public static void main(String args[]) {
        String str = "01";
       int num =  maximumK(str);
       System.out.println(num);
    }
}


