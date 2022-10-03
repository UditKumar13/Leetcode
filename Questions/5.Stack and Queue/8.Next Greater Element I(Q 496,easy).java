class Solution {
    
    public int[] nextGreaterArray(int[] arr){
        Stack <Integer> st = new Stack<>();
        int [] ngn = new int [arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i] ){
                st.pop();
            }
            
            if(i<=arr.length-1){
                if(st.isEmpty() == false) ngn[i] = st.peek();
                else ngn[i] = -1;
            }
            
            st.push(arr[i]);
        }
        
        return ngn;
    }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap <Integer,Integer> map = new HashMap<>();
        int [] ngn = nextGreaterArray(nums2);
        int [] nextGreater = new int[nums1.length];
        
        
        for(int idx=0; idx<nums2.length;idx++){
            map.put(nums2[idx],idx);
        }
        
        for(int i=0;i<nextGreater.length;i++){
            int data = nums1[i];
            int index = map.get(data);
            nextGreater[i] = ngn[index];
        }
        
        return nextGreater;
        
    }
}