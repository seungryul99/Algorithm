class Solution {
    public int solution(int[] q1, int[] q2) {
  
        int len = q1.length;
        long goal = 0;
        int[] q = new int[len*2];
        long sum1 = 0, sum2 = 0;
        
        for (int i=0; i<len; i++){
        
            q[i] = q1[i];
            q[i+len] = q2[i];
            
            sum1 += q1[i];
            sum2 += q2[i];
        }

        goal = sum1 + sum2;
        if (goal %2 != 0) return -1;
        goal /= 2;
        
        int p1 = 0, p2 = len-1;
        int res = 0;
        
        while(sum1 != goal){
        
            if (sum1 < goal){
                
                if(p2 == q.length-1) return -1;
                sum1 += q[++p2];
            }
            else if (sum1 > goal){
                
                if(p1 == p2) return -1;
                sum1 -= q[p1++];
            }
            
            res++;
        }
        
        return res;
    }
}