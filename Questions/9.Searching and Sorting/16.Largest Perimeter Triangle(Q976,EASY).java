class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n <=2) return 0;
        for(int i=n-1;i>=2;i--){
        int a = nums[i], b =nums[i-1], c = nums[i-2];
        if((a + b)>c && (b+c)>a && (c+a)>b){
            return a+b+c;
        }
        }

        return 0;
    }
}