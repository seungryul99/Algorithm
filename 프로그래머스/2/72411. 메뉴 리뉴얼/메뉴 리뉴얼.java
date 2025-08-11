import java.util.*;

class Solution {
    
    static Map<Integer, Map<String, Integer>> mp; 
    
    public String[] solution(String[] orders, int[] course) {
    
        Set<String> res = new TreeSet<>();
        
        mp = new HashMap<>();
        
        // orders를 통해서 먼저 초기화
        for (int x : course) {
            Map<String, Integer> cnt = new HashMap<>();
            mp.put(x, cnt);
        }
        
        // 각 손님의 order를 순회
        for (String s : orders){
            
            String[] randomOrder = s.split("");
            
            // order는 오름차 순이 아닐 수 있음
            Set<String> orderSet = new TreeSet<>();
            for (String e : randomOrder) orderSet.add(e);
            
            StringBuilder sb = new StringBuilder();
            for(String e : orderSet) sb.append(e);
            
            String[] order = sb.toString().split("");
            
            int len = order.length;
            
            for (int i=2; i<=10; i++){
                
                // 5C6 같은 경우는 제외
                if(len < i) break;
                
                // 코스에 포함되지 않는 경우도 제외
                Map<String, Integer> cnt = mp.getOrDefault(i, null);
                
                // nCr에서 r이 i인 조합을 구해봐야 함. 
                if(cnt != null) combi(order, len, i, cnt, new ArrayList<String>(), 0);
            }
        }

         for(int x : course){
            
             Map<String, Integer> cnt = mp.get(x);
            
             int max = -1;
            
             Set<String> st = cnt.keySet();
            
             for(String key : st) {
                 
                 int val = cnt.get(key);
                 if(max < val) max = val;
             }
             
             if (max < 2) continue;
             
             for(String key : st) {
                 
                  int val = cnt.get(key);
                  if(max == val) res.add(key);
             }
        }
        
        String[] ans = new String[res.size()];
        
        int ss = 0;
        for(String s : res) ans[ss++] = s;
        
        return ans;
    }
    
    void combi(String[] order, int n, int r, Map<String, Integer> cnt, List<String> cur, int idx){
        
        if(cur.size() == r){
            
            StringBuilder sb = new StringBuilder();
            for(String s : cur) sb.append(s);
            
            String key = sb.toString();
            int value = cnt.getOrDefault(key, 0);
            
            cnt.put(key, value + 1);
            return;
        }
        
        for (int i=idx; i<n; i++){
            
            cur.add(order[i]);
            combi(order, n, r, cnt, cur, i + 1);
            cur.remove(cur.size()-1);
        }
        
    }
}