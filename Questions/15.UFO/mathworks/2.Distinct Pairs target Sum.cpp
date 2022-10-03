#include<bits/stdc++.h>
using namespace std;

int two_sum_unique_pairs(std::vector<int> nums, int target) {
    unordered_set<int> track;
    unordered_set<int> seen;
    int totPairs = 0;
    for(int curEle : nums){
        int partner = target - curEle;
      if(track.find(partner) != track.end() and seen.find(curEle) == seen.end()){
          totPairs++;
          seen.insert(partner);
          seen.insert(curEle);
      }
      track.insert(curEle);
    }
   
    
    return totPairs;
}