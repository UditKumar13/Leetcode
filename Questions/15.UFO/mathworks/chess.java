import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         int m = Integer.parseInt(br.readLine().trim());
         char[][] a = new char[n][m];
         for(int i_a = 0; i_a < n; i_a++)
         {
         	String[] arr_a = br.readLine().split(" ");
         	for(int j_a = 0; j_a < m; j_a++)
         	{
         		a[i_a][j_a] = arr_a[0].charAt(j_a);
         	}
         }

         long out_ = solve(a);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    int max = 0;
    static long solve(char[][] a){
        
        long tot= 0;
        int row = a.length;
        int col = a[0].length;
        List<List<Integer>> bM = new ArrayList<>(); 
        List<List<Integer>> rM = new ArrayList<>();
        List<List<Integer>> qM = new ArrayList<>();

        for(int i=0;i<4;i++){
            bM.add(new ArrayList<>());
        }

        for(int i=0;i<4;i++){
            rM.add(new ArrayList<>());
        }


        for(int i=0;i<8;i++){
            qM.add(new ArrayList<>());
        }
        bM.get(0).add(1,1);
        bM.get(1).add(-1,1);
        bM.get(2).add(+1,-1);
        bM.get(3).add(-1,-1);

        rM.get(0).add(0,1);
        rM.get(1).add(0,-1);
        rM.get(2).add(1,0);
        rM.get(3).add(-1,0);

        qM.get(0).add(1,1);
        qM.get(1).add(-1,1);
        qM.get(2).add(+1,-1);
        qM.get(3).add(-1,-1);
        qM.get(4).add(0,1);
        qM.get(5).add(0,-1);
        qM.get(6).add(1,0);
        qM.get(7).add(-1,0);

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(a[i][j] == 'B' || a[i][j] == 'R' || a[i][j] == 'Q'){
                    if(a[i][j] == 'B'){
                        for(int k=0;k<bM.size();k++){
                            int nrow = bM.get(k).get(0) + i;
                            int ncol = bM.get(k).get(1) + j;
                            if(isValid(a,nrow,ncol) == true){
                                tot++;
                            }
                        }
                    }else if(a[i][j] == 'R'){
                           for(int k=0;k<rM.size();k++){
                            int nrow = rM.get(k).get(0) + i;
                            int ncol = rM.get(k).get(1) + j;
                           if(isValid(a,nrow,ncol) == true){
                                tot++;
                            }
                        }
                    }else{
                        // Q ele cur
                        for(int k=0;k<qM.size();k++){
                            int nrow = qM.get(k).get(0) + i;
                            int ncol = qM.get(k).get(1) + j;
                            if(isValid(a,nrow,ncol) == true){
                                tot++;
                            }
                        }
                    }
                }
            }
        }
        return tot;
    }

    static boolean isValid(char[][]a, int i, int j){
        int row = a.length, col = a[0].length;
        if(i<0 || i>=row || j<0 || j>=col || a[i][j] == 'B' || 
        a[i][j]  == 'R' || a[i][j] == 'Q'){
            return false;
        }
        return true;
    }
}