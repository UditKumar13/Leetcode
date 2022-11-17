class Solution {
public:
    int computeArea(int a, int b, int c, int d, int e, int f, int g, int h) {
        int area1 = (c-a) * (d-b);
        int area2 = (g-e) * (h-f);
        if(a>=g || c<=e || d<=f || b >=h ){
            // this means no overlap 
            return area1 + area2;
        }
        return area1 - (min(g,c) - max(a,e))*(min(h,d) - max(b,f))  + area2;
    }
};

//https://leetcode.com/problems/rectangle-area/solutions/62302/clean-c-solution-with-detailed-explanations/?orderBy=most_votes&languageTags=cpp
