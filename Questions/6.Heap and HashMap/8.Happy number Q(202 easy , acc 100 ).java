class Solution {
    public boolean isHappy(int n) {
        
        
        if (n == 1  || n==7) return true ;
        
        else if (n/10 == 0) return  false ; 
        
        int temp =  n; 
        int sum = 0 ;
        while (temp > 0 ){
            int rem = temp % 10  ;
            sum += rem * rem ; 
            
            temp = temp / 10 ;
        }
        
        return isHappy(sum);
    }
}



// 2nd approach :
Hashset 


class Solution {

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}


// method 3 : flyodd warshall algo :


class Solution {

     public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
