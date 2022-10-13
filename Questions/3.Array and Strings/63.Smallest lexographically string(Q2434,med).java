class Solution {
public:
    string robotWithString(string s) {
        string p,t;
        int fre[26] = {};
        int lo = 0;
        for(auto ch : s){
            ++fre[ch -'a'];
        }
        for(auto ch : s){
            t += ch;
            --fre[ch-'a'];
            while(lo<25 && fre[lo]==0){
                lo++;
            }
            while(!t.empty() && t.back()-'a' <= lo){
                p += t.back();
                t.pop_back();
            }
        }
        
        return p;
}
};