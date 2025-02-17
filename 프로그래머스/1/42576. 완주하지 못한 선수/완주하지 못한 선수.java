import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String res=null;
        Map<String, Integer> participantMap = new HashMap<>();
        
        for(String name : participant)
            participantMap.put(name, participantMap.getOrDefault(name,0)+1);
        
        
        for(String name : completion)
            participantMap.put(name, participantMap.get(name)-1);
        
        
        for(String name : participant){
            
            if (participantMap.get(name)!=0) {
                
                res = name;
                break;
            }
        }
        
        return res;
    }
}