class LUPrefix {

    Set<Integer> set;
    int count = 0;
    public LUPrefix(int n) {
        set = new HashSet<>();
    }
    
    public void upload(int video) {
        set.add(video);
        while(set.contains(count+1)) count++;
    }
    
    public int longest() {
        return count;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */