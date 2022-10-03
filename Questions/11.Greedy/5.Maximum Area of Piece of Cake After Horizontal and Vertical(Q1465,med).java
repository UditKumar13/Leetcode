class Solution {
  int mod = 1000000007;
  public int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
      Arrays.sort(hCuts);
      Arrays.sort(vCuts);
      int hGap = hCuts[0];
      for(int i=0;i<=hCuts.length-2;i++){
          int gap = hCuts[i+1] - hCuts[i];
          hGap = Math.max(hGap,gap);
      }
      hGap = Math.max(hGap,h - hCuts[hCuts.length -1]);
        int vGap = vCuts[0];
      for(int i=0;i<=vCuts.length-2;i++){
          int gap = vCuts[i+1] - vCuts[i];
          vGap = Math.max(vGap,gap);
      }
      vGap = Math.max(vGap,w - vCuts[vCuts.length -1]);
      // double num = 1e9  + 7;
      long vgap = vGap;
      return (int)((vgap * hGap) %  mod);
   
      
}
}