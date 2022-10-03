/*
Problem :
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Input: s1 = "ab", s2 = "eidbaooo"
Output: true


*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
      
      
      // use the sliding window and the + - logic with the window size of s1
      // we are sliding the window of size s1 everytime on  the s2 
      
      int len1  = s1.length() , len2 = s2.length() ;
      
      if (len1 > len2) return false ;
      
      int [] count = new int [26] ;
      // including the s1 window
      for (int i =0 ; i<len1 ; i++){
        count[s1.charAt(i)-'a']++ ;
        count[s2.charAt(i)-'a']-- ; 
      }
      
      if(allZero(count)) return true ; 
      
      for(int i = len1 ; i<len2 ; i++){
        count[s2.charAt(i)-'a']--;
        count[s2.charAt(i-len1)-'a']++  ;
        if(allZero(count)) return true ; 
      }
      
      return false ; 
      
    }
  
  boolean allZero(int [] arr){
    for (int i=0;i<26;i++){
      if (arr[i] != 0){
        return false ; 
      }
    }
    
    return true ; 
  }
}