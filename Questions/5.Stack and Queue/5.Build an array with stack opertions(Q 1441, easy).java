class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        List<String> stack_Op = new ArrayList<String>();
        int len = target.length-1;
        int pointer =0;
        
        for(int idx=0;idx<n;idx++){
            if(pointer > target.length-1) break;
            if (idx+1 == target[pointer]){
            stack_Op.add("Push");
            pointer++;
            }

            else {
            stack_Op.add("Push");
            stack_Op.add("Pop");
            }
        }
       
        return stack_Op;
        
    }
}