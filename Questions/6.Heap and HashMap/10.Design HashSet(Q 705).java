class MyHashSet {
int num[];
    public MyHashSet() {
        num = new int[31251];
    }
    
    public void add(int key) {
        num[getIdx(key)] |= getMask(key); 
    }
    
    public void remove(int key) {
        num[getIdx(key)] &= (~getMask(key));
    }
    
    public boolean contains(int key) {
        return (num[getIdx(key)]&getMask(key))!=0;
    }
    
    public int getIdx(int key){
        return (key/32);
    }
    
    public int getMask(int key){
        key %= 32;
        return (1<<key);
    }
}

// Theory
// https://leetcode.com/problems/design-hashset/discuss/769047/Java-Solution-using-Bit-Manipulation
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */