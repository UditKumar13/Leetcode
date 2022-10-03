// Approach 1 : dfs 
class Solution {
    public boolean canMeasureWater(int j1, int j2, int t) {
        if(t > j1 + j2) return false;
        boolean[] vis = new boolean[j1 +j2 +1];
        
        return helper(j1,j2,0,t,vis);
    }
    
    
    private boolean helper(int j1,int j2, int cap, int t, boolean[]vis){
        if(cap <0 || cap > j1 + j2 || vis[cap]) return false;
        
        vis[cap] = true;
        if(cap == t) return true;
        return helper(j1,j2,cap-j1,t,vis) || helper(j1,j2,cap+j1,t,vis) 
            || helper(j1,j2,cap-j2,t,vis) || helper(j1,j2,cap+j2,t,vis);
    }
}


// Approach 2 :

 // Approach 2 : Euclidean algorithm
// ax + by = z, the greatest common divider of a and b is c, z can also be divided by c.
class Solution {
    public boolean canMeasureWater(int j1, int j2, int t) {
        if(t > j1 + j2) return false;
        return t % gcd(j1,j2) == 0;
     
    }
    
    
    public int gcd(int a, int b){
        if(b ==0) return a;
        return gcd(b,a%b);
    }
}

// more fast approach 