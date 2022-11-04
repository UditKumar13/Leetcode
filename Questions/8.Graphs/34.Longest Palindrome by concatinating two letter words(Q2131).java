class Solution {
    public int longestPalindrome(String[] words) {
        int [][]counts = new int[26][26];
        int max = 0;
        for(String curr : words){
            int a = curr.charAt(0) - 'a';
            int b = curr.charAt(1) - 'a';
            if(counts[b][a] >0){
                max += 4;
                counts[b][a]--;
            }else{
                counts[a][b]++;
            }
        }

        for(int i=0;i<26;i++){
            if(counts[i][i]>0){
                max += 2;
                break;
            }
        }

        return max;
    }
}