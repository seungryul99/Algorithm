import java.util.*;

class Solution {
    
    public int solution(int[] in) {
        
        Integer[] citations = new Integer[in.length];
        for (int i=0;i<in.length;i++) citations[i] = in[i];
        
        Arrays.sort(citations, Collections.reverseOrder());
        
        int n = citations.length;
        int h = 0;
        
        
        for (int i=0; i<=10000; i++){
            
            int cnt=0;
            
            // i번 이상 인용된 논문 개수 세기
            for(int cur : citations){
                
                if(cur >= i) cnt++;
                else break;
            }
            
            int cnt2 = n-cnt;
            
            
            // h번 이상 인용된 논문이 h편 이상인지 체크
            if (i > cnt) continue;
            
            // 나머지 논문이 h번 이하로 인용된지 체크
            if (cnt2 > i) continue;
            
            h=i;
        }
  
        
        return h;
    }
}