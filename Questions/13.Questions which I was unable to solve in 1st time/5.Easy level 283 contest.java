class Solution {
    public List<String> cellsInRange(String s) {
    char fc  = s.charAt(0) ;
     char lc = s.charAt(s.length()-2) ;

     int i = s.charAt(1) -'0' ;
     int j = s.charAt(s.length()-1) -'0';
     int range = lc -fc +1; 
List<String > yes = new ArrayList<>() ;  
  for (int st=0 ; st<= range-1; st++){


   for(int m = i ; m<= j ; m++){
      char ch = (char)(fc + st) ; 
      String num = m + "" ;
      num = ch + num ; 
      yes.add(num);
   }
  }

return yes ; 
    }
}