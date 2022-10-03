class Job{
    int st;
    int end;
    int profit;
    
    Job(int _st, int _end, int _profit){
        this.st =_st;
        this.end = _end;
        this.profit = _profit;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job>jobs = new ArrayList<>();
        TreeMap<Integer,Integer>map = new TreeMap<>();
        int len = startTime.length;
        for(int i=0;i<len;i++){
            jobs.add(new Job(startTime[i],endTime[i],profit[i]));
        }
        Collections.sort(jobs,(a,b)->(a.end - b.end));
        int maxProfit = 0;
        for(Job curr_Job : jobs){
            Integer entryTillStartTime = map.floorKey(curr_Job.st);
            int maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
            maxProfit = Math.max(maxProfit,maxProfitTillStartTime + curr_Job.profit);
            map.put(curr_Job.end,maxProfit);
        }
        
        return maxProfit;
    }
}

// Approach 1 :


// Approach 2 : 
Binary search 
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] weight) {
        //dp[i] : maximum profit obtained by considering weights till ith index
        int n = startTime.length ;    
        Job jobs[] = new Job[n] ;
        for(int i=0 ; i<n ; i++){
            jobs[i] = new  Job(startTime[i],endTime[i],weight[i]) ;
        }
        Arrays.sort(jobs , (x,y)->x.end-y.end) ;
        
        int dp[] = new int[n] ;
        dp[0]=jobs[0].weight ;
        
        for(int i=1 ; i<n ; i++){
            Job myjob = jobs[i] ;
            int preindex = prede(jobs,i) ;
            dp[i] = Math.max(dp[i-1] , myjob.weight) ;
            if(preindex!=-1){
                dp[i] = Math.max(dp[i],dp[preindex]+myjob.weight) ;
            }        
        }
        return dp[n-1] ;
    }
    public int prede(Job[] jobs , int index){        
        int ll=0 , rr=index-1;
        int ans=-1 ;
        while(ll<=rr){
            int mid = ll+(rr-ll)/2 ;
            Job midjob = jobs[mid] ;
            if(midjob.end<=jobs[index].start){
                ans=mid ;
                ll=mid+1 ;
            }
            else{
                rr=mid-1 ;
            }
        }
        return ans ;
    }
    class Job{
        int start , end , weight ;
        Job(int start , int end , int weight){
            this.start = start ;
            this.end = end ;
            this.weight = weight ;
        }
    }
}