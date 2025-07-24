import java.util.*;

class Solution {
    public List solution(String[] id_list, String[] report, int k) {
        
        // 나를 신고한 사람들
        Map<String, Set<String>> cnt = new HashMap<>();
        
        // 내가 누구를 신고했는지
        Map<String, Set<String>> mp = new HashMap<>();
        
        for (String id : id_list) {
            
            cnt.put(id, new HashSet<>());
            mp.put(id, new HashSet<>());
        }
        
        StringTokenizer stk;
        for (String s : report){
            
            stk = new StringTokenizer(s);
            
            String from = stk.nextToken();
            String to = stk.nextToken();
            
            // 몇번 신고받은지 기록 
            cnt.get(to).add(from);
            
            // 누가 누구를 신고했는지 기록
            mp.get(from).add(to);
        }
        
        
        List<String> black = new ArrayList<>();
        // k번 이상 신고 당한 사람 체크
        for (String id : id_list){
            
            if(cnt.get(id).size() >= k) black.add(id);
        }

    
        List<Integer> res = new ArrayList<>();
        
        for (String cur : id_list){
            
            int count = 0;
            
            for (String target : black){
                
                if(mp.get(cur).contains(target)) count++;
            }
            
            res.add(count);
        }
        
        return res;
    }
}