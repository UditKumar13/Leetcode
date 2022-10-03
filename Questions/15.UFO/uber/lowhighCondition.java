  public int countPairs(int []a, int []b, int low, int high){
        if(a.length > b.length){
            int []temp = a;
            a = b;
            b = temp;
        }

        for(int i=0;i<a.length;i++){
            a[i] = a[i] * a[i];
        }

        Arrays.sort(a);
        // sorting takes nlogn
        int count = 0;
        for(int i=0;i<b.length;i++){
            if(b[i] *b[i] > high) continue;
            int rightBound = performBinary(a,high - b[i] * b[i]);
            count += rightBound;
        }
        return count;
    }

    public static int performBinary(int []nums, int target){
        int left = 0;
        int right = nums.length-1;
        int middle;
        middle = (right - left)/2 + left;
        if(nums[middle] == target) return middle;

        else if(nums[middle] < target) left++;
        else right--;

        return left;
    }