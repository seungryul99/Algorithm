import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {

        Map<String, Integer> dic = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        // 사전 초기화
        for (int i=65; i<=90; i++) dic.put(""+(char)i, i-64);
        
        while(msg.length() > 0){
            
            int idx = 1;
            String w = null;
            
            while(true){
                
                String now = msg.substring(0, idx);
                Integer val = dic.getOrDefault(now, null);
                
                if (val != null){
                    
                    if(idx == msg.length()) {
                        
                        msg = "";
                        res.add(dic.get(now));
                        break;
                    }
                    
                    w = now;
                    idx++;
                } 
                else {
                    
                    res.add(dic.get(w));
                    dic.put(now, dic.size()+1);
                    msg = msg.substring(w.length(), msg.length());
                    break;
                }
            }
        }
        
        return res;
    }
}