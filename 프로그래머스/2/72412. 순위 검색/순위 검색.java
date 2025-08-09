import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        
        int[] res = new int[query.length];
        Map<String, List<Integer>> mp = new HashMap<>();
        
        // info를 3 * 2 * 2 * 2 = 24 가지 중 하나의 key로 저장한다.
        for (String s : info) {
            
            String[] t = s.split(" ");
            
            String key = t[0] + "#" + t[1] + "#" + t[2] + "#" + t[3];
            int score = Integer.parseInt(t[4]);
            
            List<Integer> list = mp.getOrDefault(key, null);
            
            if(list == null) {
                list = new ArrayList<>();
                mp.put(key, list);
            }
            list.add(score);
        }
        
        // 이분탐색을 위한 정렬
        for (List<Integer> list : mp.values()) list.sort(null);
        
        
        // query를 파싱할 때, - 를 모든 조합으로 두고 해당 key들을 가져온다.
        int queryIdx = 0;
        for (String q : query){
            
            String[] t = q.replace(" and ", " ").split(" ");
            
            String[] lang = t[0].equals("-") ?  new String[]{"java", "python", "cpp"} : new String[]{t[0]};
            String[] pos = t[1].equals("-") ?  new String[]{"backend", "frontend"} : new String[]{t[1]};
            String[] old = t[2].equals("-") ?  new String[]{"junior", "senior"} : new String[]{t[2]};
            String[] food = t[3].equals("-") ?  new String[]{"chicken", "pizza"} : new String[]{t[3]};
            
            int score = Integer.parseInt(t[4]);
            
            int cnt = 0;
            for (int i=0; i<lang.length; i++){
                for(int j=0; j<pos.length; j++){
                    for(int k=0; k<old.length; k++){
                        for(int m=0; m<food.length; m++){
                            
                            String key = lang[i] + "#" + pos[j] + "#" + old[k] + "#" + food[m];
                            
                            List<Integer> list = mp.getOrDefault(key, null);
                            if(list == null) continue;
                            int idx = lowerBound(list, score);
                            
                            int p = list.size() - idx;
                            if(p>0) cnt += p;
                        }
                    }
                }
            }
            res[queryIdx++] = cnt;
        }
        
        return res;
    }
    
    // target 이상의 첫번째 위치
    public int lowerBound(List<Integer> list, int target) {
        
        int start = 0, end = list.size(); 
        
        while (start < end) {
            
            int mid = (start + end) / 2;
            
            if (list.get(mid) >= target) end = mid;
            else start = mid + 1;
        }
        return start; 
    }

}