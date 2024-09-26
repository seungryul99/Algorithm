import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int[] answer = new int[]{0,0};
       
        
        int[] cnt = new int[n+1];
        int idx = 0;
        boolean start = true;
        char prev_suffix = '0';
        
        Set<String> st = new HashSet<String>();
        
        for(String s: words) {
            
            idx++;
            cnt[idx]++;
            int prev_size = st.size();
            st.add(s);
            
            if (start == false && (prev_size == st.size() || (prev_suffix != s.charAt(0)))){
                
                answer[0] = idx;
                answer[1] = cnt[idx];
                return answer;
            }
                
            if(start== true) start = false;
            
            prev_suffix = s.charAt(s.length()-1);
            
            
            if(idx == n) idx = 0;
        }
        

        return answer;
    }
}