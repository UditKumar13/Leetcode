class Solution {
    public String getPermutation(int n, int k) {
        
        
        
        // let us do it 
        
        List <Integer> li = new ArrayList<Integer>() ;
        
        int fact = 1 ;  // factorial 
        for (int  i = 1 ;  i<=n ; i++ ){
            li.add(i) ; 
            
            if (i== n ) break ; // bcz we want n-1 ! 
           fact *= i ; 
            
        }
        
        k-- ; 
        String res = ""  ; 
        while (true){
            res = res + li.remove(k/fact) ;
            
            // update the k 
            k =  k % fact ;  
            
            if (li.isEmpty()) break ; 
            
            // update the fact 
            fact  /= li.size(); 
            
        }
        
        return res  ; 
        
    }
}