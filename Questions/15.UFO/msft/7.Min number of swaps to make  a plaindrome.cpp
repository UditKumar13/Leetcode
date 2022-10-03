void minMovesToMakePalindrome(string s) {
    int res = 0;
    bool flag = true;
    while (s.length()) {
        int leftPos = s.find(s.back());
        if (leftPos == s.length() - 1) {
            if (!flag) {
                cout << "Impossible" << endl;
                return;
            }
            res += leftPos / 2;
            flag = false;
        } else {
            res += leftPos;
            s.erase(leftPos, 1);
        }
        s.pop_back();
    }
    cout << res << endl;
}

Collections.sort(li,(a,b) -> a.cost - b.cost);