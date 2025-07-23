// 4개의 지표, 7가지 선택지  3 2 1 0 1 2 3 
// 동점 -> 사전순 

import java.util.*;

class Solution {
 
    public String solution(String[] survey, int[] choices) {
    
        Map<String, Integer> mp = new HashMap<>();
        mp.put("A",0);
        mp.put("N",0);
        mp.put("C",0);
        mp.put("F",0);
        mp.put("M",0);
        mp.put("J",0);
        mp.put("R",0);
        mp.put("T",0);
        
        
        int len = survey.length;
        for (int i = 0; i<len; i++){
            
            String cur = survey[i];
            int choice = choices[i];
            
            if(choice > 4){
                
                String key = cur.substring(1,2);
                int point = mp.get(key);
                mp.put(key, point + choice - 4);
            }
            else if (choice < 4){
                
                String key = cur.substring(0,1);
                int point = mp.get(key);
                mp.put(key, point + 4 - choice);
            }
        }
        
        String res = "";
        
        if (mp.get("R") < mp.get("T")) res += "T";
        else res += "R";
        
        if (mp.get("C") < mp.get("F")) res += "F";
        else res += "C";
        
        if (mp.get("J") < mp.get("M")) res += "M";
        else res += "J";
        
        if (mp.get("A") < mp.get("N")) res += "N";
        else res += "A";
        

        return res;
    }
}