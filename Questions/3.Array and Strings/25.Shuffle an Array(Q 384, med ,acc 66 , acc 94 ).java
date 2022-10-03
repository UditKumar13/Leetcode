
// O(n^2 ) algorithm 

class Solution {
  
    private int [] array ;
    private int [] original ; 
   
    private Random rand  =  new Random() ;
    
    private List<Integer> getArray(){
        List<Integer> asList  =  new ArrayList<Integer>() ; 
        for (int i = 0; i<array.length ; i++){
            asList.add(array[i]) ;
            
        }
        
        return asList ; 
    }
    public Solution(int[] nums) {
      array = nums ; 
      original  = nums.clone() ; 
        
        
    }
    
    public int[] reset() {
     array = original ;
        original = original.clone() ; 
        return array ; 
    }
    
    
    public int[] shuffle() {
    
        List<Integer> aux = getArray() ; 
        
        for (int i =0; i<array.length ; i++){
            int ri = rand.nextInt(aux.size());
            array[i] = aux.get(ri) ; // random number
            
            aux.remove(ri);
            
        }
        
        return array ; 
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */



2.Method 2 :
Fisher Yates Algorithm : 
TC : O(n)
SC : O(n)

// O(n^2 ) algorithm 

class Solution {
  
    private int [] array ;
    private int [] original ; 
   
    private Random rg = new Random () ; 
    
    
    private int randRange(int min, int max){
        return rg.nextInt(max-min) + min; // this will  
    }
 
    
    private void swap(int i , int j ){
        int temp  = array[i] ;
        array[i] = array[j] ; 
        array[j] = temp  ; 
    }
    
    public Solution(int[] nums) {
   
        array = nums ; 
        original  = nums.clone() ; // cloning the original array 
    }
    
    public int[] reset() {
    array = original ; 
    original = original.clone() ; // we have to add this line because now the array is pointing to original we have to clone the original first now
    return original ; 
    }
    
    
    public int[] shuffle() {
    for (int i =0 ; i<array.length ; i++){
        swap(i,randRange(i, array.length));
    }
        
        return array ; 
       
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */


