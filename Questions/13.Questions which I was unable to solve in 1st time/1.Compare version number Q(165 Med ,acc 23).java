class Solution {
    public int compareVersion(String str1, String str2) {
        
    String [] s1 = str1.split("\\.") ;
    String [] s2 = str2.split("\\.") ;
        
        
        for (String s : s1){
            System.out.println(s) ; 
        }
    
    int max = Math.max(s1.length , s2.length) ;
        
        
        for (int  i =0 ; i< max ; i++){
            
            
            Integer v1  =  i<s1.length ? Integer.parseInt(s1[i]): 0; 
            
            Integer v2 =  i<s2.length ? Integer.parseInt(s2[i]): 0 ; 
           int ans  = v1.compareTo(v2);
            
          if (ans != 0 ){
              return ans ; 
          }
            
            
        }
        
        
        
        return 0  ; 
    }
}