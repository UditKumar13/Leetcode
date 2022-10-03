


class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List <int[]> li = new ArrayList<int[]>();
        Arrays.sort(people,(a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0] );
        
        for(int[] row : people){
            int idx = row[1];
            li.add(idx,row);
        }
        
        int [][] correctOrder = new int[people.length][2];
        for(int i=0;i<li.size();i++){
            correctOrder[i] = li.get(i);
        }
        
        return correctOrder;

        
    }
}

// TC : O(n**2)

