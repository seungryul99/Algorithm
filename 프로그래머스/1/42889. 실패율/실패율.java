import java.util.*;

class Solution {
    
    static class Stage{
        
        int num;
        double success;
        
        public Stage(int num, double success){
            this.num = num;
            this.success = success;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        
        int[] cnt = new int[N+2];
        int[] psum = new int[N+2];
        List<Stage> list = new ArrayList<>();
        
        for (int x : stages) cnt[x]++;
        
        psum[N+1] = cnt[N+1];
        for (int i=N; i>=1; i--) psum[i] = psum[i+1] + cnt[i]; 
        
        for (int i=1; i<=N; i++){
            
            double success = psum[i] == 0 ? 0.0 : (double) cnt[i] / psum[i];
            list.add(new Stage(i, success));
            System.out.println(i + " : " + success);
        }
                
        return list.stream()
            .sorted((a,b)-> {
                int cmp = Double.compare(a.success, b.success);
            
                if(cmp < 0) return 1;
                if(cmp > 0) return -1;
                return Integer.compare(a.num, b.num);
            })
            .mapToInt(stage -> stage.num)
            .toArray();
    }
}