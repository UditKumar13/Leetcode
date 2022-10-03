   HashMap <Integer,Integer> hm = new HashMap <> ();
          int [] ans = new int [2] ; 
        for (int i=0 ; i<arr.length; i++){
            int rem = target - arr [i] ; 
            if (hm.containsKey(rem)){
              
                ans [0] = hm.get(rem) ; 
                ans[1] =  i;
                return ans ; 
            }
            
            // have to put in the hashmap 
            hm.put(arr[i], i);
        }
        return ans; 