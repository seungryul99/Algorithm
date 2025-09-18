import java.util.*;

class Solution {
    
    static Set<String> candidateBitSet = new LinkedHashSet<>();
    static String[][] relation;
    
    public int solution(String[][] input) {
        
        int col = input[0].length;
        int row = input.length;
        relation = input;
        
        // col C 1 ... col C col
        for (int r=1; r<=col; r++){
                        
            combi(col, r, new ArrayList<Integer>(), 0);
        }
        
        return candidateBitSet.size();
    }
    
    static void combi(int n, int r, List<Integer> tmp, int start){
        
        if (tmp.size() == r){
           
            boolean isNotDuplicate = checkDuplicate(tmp);
            
            if(isNotDuplicate){
                String bit = toBit(n, tmp);
                checkSub(bit);    
            }
        }
        
        for (int idx = start; idx < n; idx++){
            
            tmp.add(idx);
            combi(n, r, tmp, idx+1);
            tmp.remove(tmp.size()-1);
        }
    }
    
    static String toBit(int n, List<Integer> tmp){
        
        char[] bit = new char[n];
        
        for (int i=0; i<n; i++){
            
            if(tmp.contains(i)) bit[i] = '1';
            else bit[i] = '0';
        }
        
        return new String(bit);
    }
    
    static boolean checkDuplicate(List<Integer> tmp){
        
        Set<String> set = new HashSet<>();
        
        for (int i=0; i<relation.length; i++){
            
            StringBuilder sb = new StringBuilder();
            
            for (int idx : tmp){
                sb.append(relation[i][idx]);  
                sb.append("#");
            }
            
            set.add(sb.toString());
        }
        
        if (set.size() == relation.length) return true;
        return false;
    }
    
    static void checkSub(String bit){
        
        int target = Integer.parseInt(bit,2);
  
        for (String candiBit : candidateBitSet){
            
            int can = Integer.parseInt(candiBit,2);
            
            if ((target & can) == can) return;
        }
        
        candidateBitSet.add(bit);
    }
}
