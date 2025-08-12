import java.util.*;

class Solution {
    public Set<Integer> solution(String s) {
        
        // {} 제거,   ex)    2   ,   2,1   ,   2,1,3  ,    2,1,3,4
        StringTokenizer stk = new StringTokenizer(s,"{}");
        List<String> list = new ArrayList<>();
        
        // 부분집합간 ',' 제거,     ex) 2   2,1    2,1,3     2,1,3,4
        while(stk.hasMoreTokens()){
            
            String cur = stk.nextToken();
            if(cur.equals(",")) continue;
            
            list.add(cur);
        }
        
        // List에 넣고 String의 길이 기준으로 sort
        list.sort(Comparator.comparingInt(String::length));
        
        
        // 입력 순서가 보장되는 LinkedHashSet 사용
        HashSet<Integer> st = new LinkedHashSet<>();
        
        for(int i=0; i<list.size(); i++){
            
            StringTokenizer stk2 = new StringTokenizer(list.get(i), ",");
            
            while(stk2.hasMoreTokens()){
                
                st.add(Integer.parseInt(stk2.nextToken()));
            }
        }
        
        return st;
    }
}