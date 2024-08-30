import java.util.*;

class Solution {
    public String solution(String s) {
         
        
        int max = -987654321;
        int min = 987654321;
        
        // 문자열 자르기 -> String의 split() or StringTokenizer 사용인데
        // StringTokenizer가 성능이 더 좋음
        
        
        // default delimeter 공백
        StringTokenizer st = new StringTokenizer(s);
        
        while(st.hasMoreTokens()){
            
            int cur = Integer.parseInt(st.nextToken());
            
            if(cur > max) max = cur;
            if(cur < min) min = cur;
        }
        
        
        String answer = min + " " + max;
        
        return answer;
    }
}