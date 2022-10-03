int nextGreaterInt(int number) {
   string nextNumString = to_string(number + 1);
   for(int i = 1; i < nextNumString.length(); i++) {
     if(nextNumString[i] == nextNumString[i-1]) {
        int currentDig = nextNumString[i] - '0';
        if(currentDig == 9) {
            if(i - 2 >= 0) {
                nextNumString= nextNumString.substr(0, i - 2) + to_string(nextNumString[i - 2] - '0' + 1)
                                   + string(nextNumString.substr(i-1).length(), '0');
                nextNumString[i] = '1';

               if(i - 3 >= 0 && nextNumString[i - 2] == nextNumString[i - 3]) {
                    return nextGreaterInt(stoi(nextNumString));
                }
            } else {
              nextNumString= "1" + string(nextNumString.substr(i-1).length(), '0');
            }
        } else {
           nextNumString= nextNumString.substr(0,i) + to_string(currentDig + 1) + string(nextNumString.substr(i+1).length(), '0');
        }
     }
   }

   return stoi(nextNumString);
}