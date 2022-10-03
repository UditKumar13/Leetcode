using namespace std;
int largest_k(std::vector<int> nums) {
    unordered_set <int> set;
    int maxi = 0;
    for(int i=0;i<nums.size();i++){
        if(set.find(nums[i]*-1) != set.end()){
            maxi = max(maxi,abs(nums[i]));
        }
        else{
            set.insert(nums[i]);
        }
    }
    return maxi;
}

