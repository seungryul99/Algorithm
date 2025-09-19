import java.util.*;

class Solution {
    public List<String> solution(String[] record) {
        
        Map<String, String> mp = new HashMap<>();
        
        for (String s : record){
            
            String[] sp = s.split(" ");
            
            if(sp[0].equals("Enter") || sp[0].equals("Change")){
                
                String key = sp[1];
                String val = sp[2];
                
                mp.put(key, val);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for (String s : record){
            
            String[] sp = s.split(" ");
            
            if (sp[0].equals("Enter")) res.add(new String(mp.get(sp[1])+"님이 들어왔습니다."));
            else if (sp[0].equals("Leave")) res.add(new String(mp.get(sp[1])+"님이 나갔습니다."));
        }
        
        
        return res;
    }
}