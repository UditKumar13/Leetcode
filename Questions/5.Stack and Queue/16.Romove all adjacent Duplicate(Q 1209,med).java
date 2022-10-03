class Solution {
      public String removeDuplicates(String s, int k) {  
          int i=0, n = s.length(), count[] = new int[n];
          char[] stack = s.toCharArray();
          for(int j=0;j<n;++i,++j){
              stack[i] = stack[j];
              count[i] = i>0 && stack[i-1] == stack[i] ? count[i-1] + 1 : 1;
              if(count[i] == k) i-=k;
          }
          return new String(stack,0,i);
    }
}