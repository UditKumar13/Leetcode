class Solution {
public:
    int minMovesToMakePalindrome(string s) {
        int left = 0, right = s.size()-1;
        int minMoves = 0;
        while(left < right){
            int l = left, r = right;
            while(s[l] != s[r]) r--;
            // find the index from the right which matches with the curr left
            // once you have found that usko last mein lekrr jaana hai
            // here 2 cases appears 
            if(l==r){
                // this can be the case for string like abb humko bas bab krna hai so,
                swap(s[r],s[r+1]);
                minMoves++;
                continue;
            }
            else{//sahi position prr lekkrr jao swap krate krate 
                while(r < right){
                    swap(s[r],s[r+1]);
                    r++;
                    minMoves++;
                }
            }
            left++;
            right--;
        }
        return minMoves;
    }
};