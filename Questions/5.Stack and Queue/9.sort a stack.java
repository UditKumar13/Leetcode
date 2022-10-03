static void sortStack(Stack<Integer> s){
    
    while(!s.isEmpty()){
        int currEle = s.pop();
        sortStack(s);
        nowInsertBack(s,currEle);
    }
}

public void nowInsertBack(Stack<Integer>s, int ele){
    
    if(s.isEmpty() || ele >s.peek()){
        s.push(ele);
    }
    
    else{
        int temp = s.pop();
        nowInsertBack(s,ele);
        s.push(temp);
    }
}