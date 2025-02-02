import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        
        Map<String, Integer> dic = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        // 사전 초기화
        for (int i=65; i<=90; i++) dic.put(String.valueOf((char)i),i-64);

        for (int i=0; i<msg.length();){
            
            int idx = 0;
            
            for (int j=i+1; j<=msg.length(); j++){
                
                String key = msg.substring(i,j);
                
                if(dic.containsKey(key)) {
                    idx = dic.get(key);
                
                    if(j==msg.length()){
                        System.out.println(key);
                        res.add(idx);
                        i+= j;
                        break;
                    }
                }
                else {
                    
                    dic.put(key,dic.size()+1);
                    res.add(idx);
                    i+= j-i-1;
                    break;
                }
            }
        }
        
        return res;
    }
}