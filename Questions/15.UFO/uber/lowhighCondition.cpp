// https://leetcode.com/discuss/interview-question/1061013/Uber-OA

#include <iostream>
using namespace std;
int main() {
    int a[] = {3,-1,9};
    int b[] = {100,5,-2};
    int satCond = 0;
    int low, high;
    
    cin>>low;
    cout<<"Enter the lower"<<low<<endl;

    cin>>high;
    cout<<"Enter the higher :"<<high<<endl;
    int alen = sizeof(a)/sizeof(a[0]);
    int blen = sizeof(b)/sizeof(b[0]);

    for(int i=0;i<alen;i++){
        for(int j=0;j<blen;j++){
            int temp = (a[i]*a[i]) + (b[j]*b[j]);
            if((low <= temp) && (temp <= high)) satCond++;
        }
    } 
    cout << "Number of times the condition is satisfying is : " << satCond;
    return 0;
}
