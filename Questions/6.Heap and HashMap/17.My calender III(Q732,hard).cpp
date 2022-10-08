class MyCalendarThree {
public:
    map<int,int> mp;
    int maxCount = 0;
    MyCalendarThree() {
        
    }
    
    int book(int start, int end) {
        mp[start]++;
        mp[end]--;
        int count = 0;
    for(auto it = mp.begin(); it!= mp.end();it++){
            count += it->second;
        maxCount = max(maxCount,count);
        }
        return maxCount;
    }
};

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree* obj = new MyCalendarThree();
 * int param_1 = obj->book(start,end);
 */