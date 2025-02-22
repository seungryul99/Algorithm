import java.util.*;

class Job{
    
    int progress;
    int speed;
    public Job(int progress, int speed){
        this.progress = progress;
        this.speed = speed;
    } 
}

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        
        Queue<Job> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i=0; i< progresses.length; i++) q.add(new Job(progresses[i],speeds[i]));
        
        int cnt = 0;
        while (!q.isEmpty()){
        
            int res = 0;
            cnt++;
            
            while(true){
                
                Job cur = q.peek();
            
                if(cur != null && cur.progress + cur.speed * cnt >= 100) {
                    res++;
                    q.poll();
                }
                else break;
            }
         
            if (res>0) list.add(res);
        }
        
        return list;
    }
}