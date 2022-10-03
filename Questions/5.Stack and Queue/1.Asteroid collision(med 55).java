/*

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
*/

class Solution {
    public int[] asteroidCollision(int[] ast) {
     // dynammic so that we have to use LL
      
      LinkedList <Integer> li = new LinkedList<>() ;
      
      // Intutuive method 
      for (int val : ast){
        
        if (val > 0 ){
          // agar +ve asteroid hai , so no need to think bcz woh jaa hi right rha hai 
          // simply add 
          li.add(val) ; 
        }
        
        else{
          
          while (!li.isEmpty() && li.getLast() >0 && li.getLast() < -val){
            // agar koi bada -ve asteroid aa rha ahi auur last linked list mein smaller +ve hai
            // so it will get destroy
            li.pollLast() ; 
          }
          
           if(!li.isEmpty() && li.getLast() == -val){
            // equal hai they both will destroy once again 
            li.pollLast() ; 
          }
          
          else if(li.isEmpty() || li.getLast() < 0 ){
            li.add(val);
          }
          
        }
      }
      
       return li.stream().mapToInt(i->i).toArray();
      
    }
}