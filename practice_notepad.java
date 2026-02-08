class Solution{

// we were calculating the already calculated wrong positions
// Approach 2 : use of Prefix and Suffix

//bCountLeft[i]: number of 'b's from index 0 to index i-1
//aCountRight[i]: number of 'a's from n-1 to i+1 
public int minimumDeletions(String s){

int n = s.length();
int[] bCountLeft = new int[n+1];
int[] aCountRight = new int[n+1];

for(int i=0; i<n; i++){
bCountLeft[i+1] = bCountLeft[i] + (s.charAt(i) == 'b' ? 1: 0);
}

for(int i=n-1; i>=0; i--){
aCountRight[i] = aCountRight[i+1] + (s.charAt(i) == 'a' ? 1: 0);
}



}
}