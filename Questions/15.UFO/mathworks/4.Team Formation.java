  public static long getScores(int[] scores, int size, int m) {

         Comparator<int[]> comparator = new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
              if (b[0] == a[0]) {
                 return a[1] - b[1];
              }
              return b[0] - a[0];
            }
         };

         PriorityQueue<int[]> leftPart = new PriorityQueue(comparator);
         PriorityQueue<int[]> rightPart = new PriorityQueue(comparator);

         int left = m - 1;
         int right = scores.length - m;
         for (int i = 0; i <= left && i < scores.length; i++) {
            leftPart.offer(new int[]{scores[i], i});
         }

         for (int i = scores.length - 1; i >= right && i > left && i >= 0; i--) {
           rightPart.offer(new int[]{scores[i], i});
         }

         long result = 0;
         while (size-- > 0 && (!leftPart.isEmpty() || !rightPart.isEmpty())) {
           int leftMax = !leftPart.isEmpty() ? leftPart.peek()[0]: -1;
           int rightMax = !rightPart.isEmpty() ? rightPart.peek()[0]: -1;

           if (leftMax >= rightMax) {
             result += leftMax;
             leftPart.poll();
             if (left + 1 < right && left + 1 < scores.length) {
               leftPart.offer(new int[]{scores[++left], left});
             }
           } else {
             result += rightMax;
             rightPart.poll();
             if (right - 1 > left && right - 1 >= 0) {
               rightPart.offer(new int[]{scores[--right], right});
             }
           }
         }
         return result;
 }

 public static void main(String[] args) {
         int[] nums1 = { 17, 12, 10, 2, 7, 2, 11, 20, 8 };
         int size1 = 3, m1 = 8;
         System.out.println(getScores(nums1, size1, m1));
 }