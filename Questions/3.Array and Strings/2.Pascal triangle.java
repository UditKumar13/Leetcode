class Solution {
    public List<List<Integer>> generate(int num) {
       
      
      List <List<Integer>> sol = new ArrayList<>() ; 
      List <Integer> row = new ArrayList<Integer>() ;
      
  
      
      for(int i=0;i<num ; i++){
        
        for(int j = row.size()-1; j>=1; j--){
          // do the updation
          
          row.set(j,row.get(j) + row.get(j-1)) ; 
        }
         // append 1 at the end
        row.add(1);
        sol.add(new ArrayList(row));
      }
     
      
      return sol ; 
    }
}