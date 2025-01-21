import java.util.*;

class Solution {
    
    static void convertMap(Map<String,Integer> mp, String str){
        
        String sub = null;
        
        for (int i=0; i<str.length()-1; i++){
            
            sub = str.substring(i,i+2);
        
            if(sub.charAt(0) >= 'a' && sub.charAt(0) <= 'z' && sub.charAt(1) >= 'a' && sub.charAt(1) <= 'z') {
                if(mp.containsKey(sub)) mp.put(sub, mp.get(sub)+1);
                else mp.put(sub,1);
            }
        }
    }
    
    public int solution(String str1, String str2) {
      
        // 모두 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 다중집합 원소 카운팅 맵으로 변환
        Map<String,Integer> mp1 = new HashMap<>();
        Map<String,Integer> mp2 = new HashMap<>();
        convertMap(mp1, str1);
        convertMap(mp2, str2);
        
        // [flow]
        // 1. 집합 A를 기준으로 집합 B 비교 하면서 겹치는 Key 탐색 후 Union, InterSection 계산
        // 2. 집합 B를 기준으로 남은 모든 원소를 Union에 합함
    
        int union = 0, intersection = 0;
        List<String> checked = new ArrayList<>();
        
        for(String e1 : mp1.keySet()){
            
            if(mp2.containsKey(e1)){
                
                checked.add(e1);
                
                int value1 = mp1.get(e1);
                int value2 = mp2.get(e1);
                
                if (value1 == value2) {
                    union += value1;
                    intersection += value1;
                }
                else if (value1 > value2){
                    union += value1;
                    intersection += value2;
                }
                else {
                    union += value2;
                    intersection += value1;
                }
            }
            
            else union += mp1.get(e1);
        }
        
        for(String e2 : mp2.keySet()){
            
            if(checked.contains(e2)) continue;
            union += mp2.get(e2);
        }
        
        if(union == 0 && intersection ==0) return 65536;
        else return (int)((double)intersection/union*65536);
    }
}