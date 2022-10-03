// Brute force is TC :O(n*3) SC : O(1)

// Better approach 
// TC : O(n*2) SC : O(1)



class Solution {
 
    public boolean find132pattern(int[] arr) {
        int mine = arr[0], n = arr.length;
        for(int j=0;j<n;j++){
            for(int k= j+1; k<n;k++){
                if(arr[k] > mine && arr[j] > arr[k]) return true;
                mine = Math.min(mine,arr[j]);
            }
        }
        
        return false;
        
    }
}


// Best approach using extra space 

// TC O(n)
// SC O(n)

nums[i] < nums[k] < nums[j]

we will loop  through i 
and if some how we know the values of nums[k] and nums[j]
we can check the question condition and the problem can  be solved in O(n)

We will maintain the nums [j] in the stack and nums[k]  in the seperate variable and check the main condition every time with the reverse loop of i 

if at any point, we get the result, we return true

 class Solution {
 
    public boolean find132pattern(int[] arr) {
        Stack <Integer> st = new Stack<>();
        int arr_k = Integer.MIN_VALUE, n = arr.length;
        for(int i=n-1;i>=0;i--){
            if(arr[i] < arr_k) return true;
            while(!st.isEmpty() && st.peek() < arr[i]){
                arr_k = st.peek();
                st.pop();
            }
            st.push(arr[i]);
            
        }
        return false;
    }
}



