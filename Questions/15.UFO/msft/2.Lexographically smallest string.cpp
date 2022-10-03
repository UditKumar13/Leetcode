#include <iostream> // cin, cout
#include <string> // getline, string
#include <bits/stdc++.h>
using namespace std;
std::string smallest_string(std::string s) {
    int len = s.length();
    string result(s);
    int idx = 0;
    for(;idx<len;idx++){
        if(s[idx] > s[idx+1]) break;
    }
    result.erase(idx,1);
    return result;
}

int main() {
    std::string s;
    std::getline(std::cin, s);
    std::string res = smallest_string(s);
    std::cout << res << '\n';
}
