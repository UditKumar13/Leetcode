class Solution {
    public List<List<String>> partition(String s) {
        
        
        List<List<String >> res = new ArrayList<>() ;
        List<String> li = new ArrayList<>() ; 
        palindrome_partioning(0,res ,li ,s)  ; 
        return res ; 
        
    }
    
    public void palindrome_partioning(int idx , 
        List<List<String>> res, List<String> li , String s ){
        
        
        // base case 
        
        
        if (idx == s.length()){
            
            // lotne se phle ekk kaamm krr , ke res mein ye li daal de
            res.add(new ArrayList<>(li) );
            return ; 
        }
        
        for (int  i = idx ; i< s.length (); i++ ){
            
            
             if(isPali(s,idx,i)){
                 // checking this substring as a palindrome or not if yes then only continue 
                 
                 li.add(s.substring(idx,i+1)) ; 
                 // addind this substring becasuse it is a substring 
                 palindrome_partioning(i+1, res, li, s) ;
                 
                 li.remove(li.size()-1) ; 
             }
        }
    }
    
    
    public boolean isPali(String uk, int start, int end){
        
    while (start <= end ){
        if (uk.charAt(start++) !=  uk.charAt(end--)){
            return false ; 
        }
        
       
    }
        
        return true ; 
        
    }
}