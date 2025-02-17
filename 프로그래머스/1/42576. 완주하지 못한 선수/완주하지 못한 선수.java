import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String res=null;
        Map<String, Integer> participantMap = new HashMap<>();
        
        for(String name : participant){
            
            if(!participantMap.containsKey(name)) participantMap.put(name,1);
            else participantMap.put(name, participantMap.get(name)+1);
        }
        
        for(String name : completion){
            
            Integer target = participantMap.get(name);
            
            if(target == null) {
                res = name;
                break;   
            }
            else participantMap.put(name, target-1);
        }
        
        for(String name : participant){
            
            if (participantMap.get(name)!=0) {
                
                res = name;
                break;
            }
        }
        
        return res;
    }
}