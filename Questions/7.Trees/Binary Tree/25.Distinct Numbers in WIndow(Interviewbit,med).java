public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> dniw = new ArrayList<>();
        if(B > A.size()) return dniw;
        int ws = B;
        for(int i=0;i<A.size() - B + 1;i++){
            HashSet<Integer> hs = new HashSet<>();
            int countDis = 0;
            for(int j=0;j<B;j++){
                int idx = i + j;
                int num = A.get(idx);
                hs.add(num);
            }
            countDis = hs.size();
            dniw.add(countDis);
        }

        return dniw;
    }
}


// TC : O (n**2)

// SC : O (n)


// Approach 2 using the Hashmap 
public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> dniw = new ArrayList<>();
        if(B > A.size()) return dniw;
        HashMap <Integer,Integer> map = new HashMap <>();
        for(int i=0;i<=B-2;i++){
            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
        }

        for(int j=0, i= B-1; i<A.size(); i++){
            // acquire 
            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
            // work 
            dniw.add(map.size());
            // release 
            int freq = map.get(A.get(j));
            if(freq == 1){
                map.remove(A.get(j));
            }

            else{
                map.put(A.get(j),freq-1);
            }

            j++;
        }
        return dniw;
    }

}

// TC : O(n)

// Sc : O(n)

