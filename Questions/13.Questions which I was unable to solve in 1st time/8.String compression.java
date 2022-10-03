class Solution {
    public int compress(char[] chars) {
        int index =0, count =0;
        int len = chars.length;
        for(int i=0;i<chars.length;i++){
            count++;
            if(i==len-1 || chars[i] != chars[i+1]){
                chars[index++] =chars[i];
                
                if(count !=1 ){
                    for(char ch : Integer.toString(count).toCharArray()){
                        chars[index++] =ch; 
                    }
                }
                
                count = 0;
            }
            
           
        
        }
        return index;
    }
    
}