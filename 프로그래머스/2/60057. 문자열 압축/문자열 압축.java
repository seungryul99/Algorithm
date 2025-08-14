import java.util.*;

class Solution {
    public int solution(String s) {
        
        int len = s.length();
        int res = s.length();
        
        for (int unit=1; unit<=len/2; unit++){
             
            List<String> sep = seperate(s, unit);
            
            int cnt = 0;
            Deque<String> stk = new ArrayDeque<>();
            
            for (String cur : sep){
                    
                if(stk.isEmpty()) stk.push(cur);
                else{
                    
                    if(stk.peek().equals(cur)) stk.push(cur);
                    else {
                        if(stk.size()==1) cnt += stk.peek().length();
                        else {
                            String k = String.valueOf(stk.size());
                            cnt += stk.peek().length() + k.length();
                        }
                        
                        stk.clear();
                        stk.push(cur);
                    }
                }
            }
            
             if(stk.size()==1) cnt += stk.peek().length();
             else {
                String k = String.valueOf(stk.size());
                cnt += stk.peek().length() + k.length();
            }
            
            if(cnt < res) res = cnt;
        }
        
        return res;
    }
    
    List<String> seperate(String s, int unit){
        
        List<String> sep = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
   
        for(int i=0; i<s.length(); i++){
            
            sb.append(s.charAt(i));
                    
            if(sb.length() == unit) {
                sep.add(sb.toString());
                sb = new StringBuilder("");
            }
            
        }
        if(sb.length() != 0) sep.add(sb.toString());
        
        return sep;
    }
}