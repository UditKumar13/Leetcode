  
      HashMap <Integer, Integer> map = new HashMap <>() ;
      int psum = 0 ; 
      int max =0  ; 
      for (int i = 0; i<arr.length ; i++){
        
        psum += arr[i] ; 
        
        if (psum == 0){
          max = i + 1 ; 
        }
        
        else{
           if(map.containsKey(psum)){
          int j = map.get(psum);
          j = i - j ; 
          
          max = Math.max(max,j) ; 
        }
        
        else {
          // does not contain simply put
          map.put(psum,i) ; 
        }
        }
      
       
      }
      return max ; 