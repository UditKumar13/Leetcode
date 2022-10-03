class Solution {
    public int compareVersion(String version1, String version2) {
        
int num1  = 0 , num2 = 0 ; // take the num we want to make 

int len1 = version1.length ();
int len2 = version2.length()  ; 
        
int  i = 0, j = 0 ;
        
        
        
        while(i<len1 || j<len2){
            
            
        num1 = 0 ; // initializing once again for another number after the dot
        num2 = 0 ; 
            
            while (i<len1 && version1.charAt(i) != '.'){
                num1 = num1*10 + version1.charAt(i++) - '0' ;   
            }
            
            while (j<len2 && version2.charAt(j) != '.'){
                num2 = num2*10 + version2.charAt(j++)  - '0' ;  
            }
            
            
            if (num1 < num2){
                return -1 ; 
            }
            
            else if (num1 > num2){
                return 1 ; 
            }
            
            
            else {
                // this means 2 numbers are same and we are standing at the the dot
                
                i++ ; 
                j++ ; 
                
            }
            
        }
        
        
        
        return  0 ; 
        
        
        
    }

}
