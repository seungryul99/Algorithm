import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        
        // 최대로 많은 부서에 물품을 지원 하려면 가장 작은 애들 부터 처리해주면 됨
        
        Arrays.sort(d);
        
        int cnt = 0;
        
        while(true){
            
            if(cnt == d.length) break;
            if(budget - d[cnt] < 0) break;
            
            
            budget -= d[cnt];
            cnt ++;
        }
        
        return cnt;
    }
}