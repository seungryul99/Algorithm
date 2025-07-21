import java.util.*;

class Solution {
  
    public int solution(String[] friends, String[] gifts) {

        Map<String, Map<String, Integer>> cnt = new HashMap<>();
        Map<String, Integer> givePoint = new HashMap<>();
        Map<String, Integer> takePoint = new HashMap<>();
        int[] res = new int[friends.length];
        
        // init cnt
        for (String s : friends) cnt.put(s, new HashMap<String, Integer>());
        
        // parse gifts
        StringTokenizer stk = null;
        
        for (String s : gifts) {
            
            stk = new StringTokenizer(s);
            
            String from = stk.nextToken();
            String to = stk.nextToken();
            
            Map<String, Integer> map = cnt.get(from);
             
            int curCnt = map.getOrDefault(to,0);
            map.put(to, curCnt + 1);
            
            int curGivePoint = givePoint.getOrDefault(from, 0);
            int curTakePoint = takePoint.getOrDefault(to, 0);
            
            givePoint.put(from, curGivePoint + 1);
            takePoint.put(to, curTakePoint + 1);
        }
    
        // friends[0] 부터 자신이 받을 수 있는 선물 개수 계산
        // 내 시점에서만 처리, 내가 받을 수 있는가 없는가
        int idx = 0;
        for (String me : friends){
            
            Map<String, Integer> map = cnt.get(me);
            
            for (String target : friends){
                
                if (me.equals(target)) continue;
                int meToTarget = map.getOrDefault(target, 0);
                int targetToMe = cnt.get(target).getOrDefault(me, 0);
                
                // 주고 받은 기록이 없는 경우, 같은 경우 -> 선물 지수로 따짐
                // 선물 지수 (준 선물 수 - 받은 선물 수)가 큰 사람이 받음
                if (meToTarget == 0 && targetToMe == 0 || meToTarget == targetToMe){
                    
                    int myPoint = givePoint.getOrDefault(me, 0) - takePoint.getOrDefault(me, 0);
                    int targetPoint = givePoint.getOrDefault(target, 0) - takePoint.getOrDefault(target, 0); 
                    
                    if(myPoint > targetPoint) res[idx]++;
                }                
                // 그 외, 두 사람 중 더 많은 선물을 준 사람이 다음 달에 선물을 받음
                else {
                    
                    if(meToTarget > targetToMe) res[idx]++;
                }
            }
            idx++;
        }
        

        int max = 0;
        for (int i=0; i<friends.length; i++) {
            if(max < res[i]) max = res[i];
        }
        
        return max;
    }
}