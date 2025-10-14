import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Map<String, Integer> mp1 = new HashMap<>();
        Map<String, Integer> mp2 = new HashMap<>();
        
        for (int i=0; i<str1.length()-1; i++){
            
            String key = str1.substring(i,i+2);
            
            if(key.charAt(0) < 'A' || key.charAt(0) > 'Z') continue;
            if(key.charAt(1) < 'A' || key.charAt(1) > 'Z') continue;
            
            Integer val = mp1.getOrDefault(key, 0);
            mp1.put(key, val + 1);
        }
        
        for (int i=0; i<str2.length()-1; i++){
            
            String key = str2.substring(i,i+2);
            
            if(key.charAt(0) < 'A' || key.charAt(0) > 'Z') continue;
            if(key.charAt(1) < 'A' || key.charAt(1) > 'Z') continue;
            
            Integer val = mp2.getOrDefault(key, 0);
            mp2.put(key, val + 1);
        }
        
        if(mp1.size() == 0 && mp2.size()==0) return 65536;
        
        int inter = 0, union = 0;
        
        for (String key1 : mp1.keySet()){
           
            Set<String> key2Set = mp2.keySet();
            
            if(key2Set.contains(key1)){
                
                int val1 = mp1.get(key1);
                int val2 = mp2.get(key1);
                
                inter += val1 > val2 ? val2 : val1;
                union += val1 > val2 ? val1 : val2;
            }
            else union += mp1.get(key1);
        }
        
        for (String key2 : mp2.keySet()){
            
            Set<String> key1Set = mp1.keySet();
            
            if(key1Set.contains(key2)) continue;
            else union += mp2.get(key2);
        }
        
        return (int)(((double)inter / union) * 65536);
    }
}