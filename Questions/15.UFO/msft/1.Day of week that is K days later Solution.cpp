#include <iostream> // cin, cout, streamsize
#include <limits> // numeric_limits
#include <string> // getline, string
#include <bits/stdc++.h>
// #include <unordered_map>
// #include <vector>
// #include<string.h>
// #include<cstring>
using namespace std;
std::string day_of_week(std::string day, int k) {
    unordered_map <string,int>hm;
    vector<string> v = {"Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    hm["Monday"] = 1;
    hm["Tuesday"] = 2;
    hm["Wednesday"] = 3;
    hm["Thurday"] = 4;
    hm["Friday"] = 5;
    hm["Saturday"] = 6;
    hm["Sunday"] = 0;
    
    
    
    int curr_day = hm[day];
    curr_day = (curr_day  + k )%7;
    string ans = v[curr_day];
    
    return ans;
}

void ignore_line() {
    std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
}

int main() {
    std::string day;
    std::getline(std::cin, day);
    int k;
    std::cin >> k;
    ignore_line();
    std::string res = day_of_week(day, k);
    std::cout << res << '\n';
}
