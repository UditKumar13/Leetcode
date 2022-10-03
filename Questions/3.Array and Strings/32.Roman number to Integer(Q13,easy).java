class Solution {
    public int romanToInt(String s) {
        char [] roman = {'I','V','X','L','C','D','M'};
        int [] values  = {1,5,10,50,100,500,1000};
        HashMap <Character,Integer> map = new HashMap<>();
        
        int len = s.length(), sum = 0;
        int idx = 0;
        
        for(int i=0;i<roman.length;i++){
            char ch = roman[i];
            map.put(ch,values[i]);
        }
        
        for(int i=0;i<len;i++){
            
            if(i <= len-2){
            char ch = s.charAt(i);
            char ch2 = s.charAt(i+1);
            if(ch == 'I'){
                if(ch != ch2 && map.get(ch) < map.get(ch2))
                sum -= map.get(ch);
                    
                else 
                sum += map.get(ch);
            }
            
            else if(ch == 'V'){
                   if(ch != ch2 && map.get(ch) < map.get(ch2))
                sum -= map.get(ch);
                    
                else 
                sum += map.get(ch);
            }
            
            else if(ch == 'X'){
                   if(ch != ch2 && map.get(ch) < map.get(ch2))
                sum -= map.get(ch);
                    
                else 
                sum += map.get(ch);
            }
            else if(ch == 'L'){
               if(ch != ch2 && map.get(ch) < map.get(ch2))
                sum -= map.get(ch);
                    
                else 
                sum += map.get(ch);
            }
            else if(ch == 'C'){
                 if(ch != ch2 && map.get(ch) < map.get(ch2))
                sum -= map.get(ch);
                    
                else 
                sum += map.get(ch);
            }
            else if(ch == 'D'){
              if(ch != ch2 && map.get(ch) < map.get(ch2))
                sum -= map.get(ch);
                    
                else 
                sum += map.get(ch);
            }
            else if(ch == 'M'){
                 if(ch != ch2 && map.get(ch) < map.get(ch2))
                sum -= map.get(ch);
                    
                else 
                sum += map.get(ch);
            }
            
            else {
                sum += 0;
            }
                
               
            }
            
            
            else {
                char ch = s.charAt(i);
                sum += map.get(ch);
            }
           
            
            
        }
        
        return sum;
        
    }
}