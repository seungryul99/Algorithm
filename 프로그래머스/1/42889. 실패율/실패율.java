import java.util.*;

class Pair implements Comparable<Pair>{
        
    int stage;
    double fail;
        
    public Pair(int stage, double fail){
        this.stage = stage;
        this.fail = fail;
    }
     
    @Override
    public int compareTo(Pair p) {
        
        if (this.fail < p.fail) return 1;
        if (this.fail > p.fail) return -1;
        
        return this.stage < p.stage ? -1 : 1;
    }
    
}

class Solution {
    
    public int[] solution(int N, int[] stages) {
        
        // cnt 배열로 각 개수 카운팅 + 누적합 계산
        int[] cnt = new int[N+2];
        int[] psum = new int[N+2];
        
        for (int e : stages) cnt[e]++;
        for (int i=1; i<=N+1; i++) psum[i] = psum[i-1] + cnt[i];
        
        // 각 스테이지의 실패율 계산
        List<Pair> failList = new ArrayList<>();
        for (int i=1; i<=N; i++) failList.add(new Pair(i,(double)cnt[i] / (psum[N+1] - psum[i-1])));
        
        // 정렬
        failList.sort(Comparator.naturalOrder());
        
        int[] res = new int[N];
        for(int i=0; i<failList.size();i++) res[i] = failList.get(i).stage;
        
        return res;
    }
}