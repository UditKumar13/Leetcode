class Solution {
   
    public int calPoints(String[] ops) {
        
        int sum =0;
        LinkedList<Integer> link = new LinkedList<>();
        for(String str : ops){
            if(str.equals("C")){
                sum -= link.peekLast();
                link.removeLast();
            }
            
            else if(str.equals("D")){
               link.addLast(2*link.peekLast());
                sum += link.peekLast();
            }
            
            else if(str.equals("+")){
                link.addLast(link.peekLast() + link.get(link.size()-2));
                sum += link.peekLast();
            }
            
            else{
            link.addLast(Integer.parseInt(str));
            sum += link.peekLast();
            } 
          
        }
        return sum;
    }
}