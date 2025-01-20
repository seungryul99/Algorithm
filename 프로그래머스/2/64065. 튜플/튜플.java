import java.util.*;

class Solution {
    public Set<Integer> solution(String s) {
        
        StringTokenizer stk = new StringTokenizer(s,"{}");
        List<String> list = new ArrayList<>();
        
        while(stk.hasMoreTokens()){
            
            String cur = stk.nextToken();
            if(cur.equals(",")) continue;
            
            list.add(cur);
        }
        
        list.sort(Comparator.comparingInt(String::length));
        
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