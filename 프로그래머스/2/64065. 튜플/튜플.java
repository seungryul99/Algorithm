import java.util.*;

class Solution {
    public int[] solution(String s) {
       
        // 변수이름이 생각이 안남
        StringTokenizer stk =new StringTokenizer(s, ",{}");
        
        Map<Integer, Integer> mp = new HashMap<>();
        Map<Integer, Integer> orderMap = new TreeMap<>();
        
        
        while(stk.hasMoreTokens()){
            
            int key = Integer.parseInt(stk.nextToken());
            int value = mp.getOrDefault(key, 0);
            
            mp.put(key, value+1);
        }        
        
        Set<Integer> st = mp.keySet();
        
        for (int key : st){
            
            int value = mp.get(key);
            orderMap.put(value, key);
        }
        
        int[] ans = new int[mp.size()];
        int idx = mp.size()-1;
        
        for (int i : orderMap.values()) ans[idx--] = i;
        
    
        return ans;
    }
}