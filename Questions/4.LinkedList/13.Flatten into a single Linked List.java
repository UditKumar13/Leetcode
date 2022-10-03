  
        if (a.data < b.data){
            temp.bottom = a ;
            temp = temp.bottom ; 
            a = a.bottom ; 
            
        }
        
        
        else {
            temp.bottom = b;
            temp = temp.bottom ; 
            b = b.bottom ; 
        }
