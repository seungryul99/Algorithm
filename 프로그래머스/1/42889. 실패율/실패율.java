import java.util.*;

class Solution {
    
    static class Stage implements Comparable<Stage>{
        
        int num;
        double success;
        
        public Stage(int num, double success){
            this.num = num;
            this.success = success;
        }
        
        @Override
        public int compareTo(Stage otherStage){
            
            if (this.success < otherStage.success) return 1;
            if (this.success > otherStage.success) return -1;
            return this.num < otherStage.num ? -1 : 1;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        
        int[] cnt = new int[N+2];
        int[] psum = new int[N+2];
        Set<Stage> st = new TreeSet<>();
        
        for (int x : stages) cnt[x]++;
        
        psum[N+1] = cnt[N+1];
        for (int i=N; i>=1; i--) psum[i] = psum[i+1] + cnt[i]; 
        
        for (int i=1; i<=N; i++){
            
            double success = (double) cnt[i] / psum[i];
            st.add(new Stage(i, success));
        }
        
        int[] res = new int[N];
        int idx = 0;
        for (Stage s : st) res[idx++] = s.num; 
        
        return res;
    }
}