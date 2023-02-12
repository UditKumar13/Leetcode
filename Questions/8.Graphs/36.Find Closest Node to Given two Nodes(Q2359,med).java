class Solution {
    
    public void bfs(int src, int []dist,  int []edges, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while(q.size()>0){
            int curr = q.poll();
            if(edges[curr]!= -1 && dist[edges[curr]] == Integer.MAX_VALUE){
                q.add(edges[curr]);
                dist[edges[curr]] = dist[curr] + 1;
            }
        }
    }
    public int closestMeetingNode(int[] e, int n1, int n2) {
        // n1 : node 1, n2 : node2
        int n = e.length;
        int []A = new int[n];
        int []B = new int[n];
        Arrays.fill(A,Integer.MAX_VALUE);
        Arrays.fill(B,Integer.MAX_VALUE);
        bfs(n1,A,e,n);
        bfs(n2,B,e,n);
        int res = Integer.MAX_VALUE, node = -1;
        for(int i=0;i<n;i++){
            if(A[i] == Integer.MAX_VALUE || B[i] == Integer.MAX_VALUE) continue;
            if(res > Math.max(A[i],B[i])){
                res = Math.max(A[i],B[i]);
                node = i;
            }
        }
        return node;
    }
}