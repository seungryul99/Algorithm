import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        
        Set<Integer> st = new TreeSet<>();
        
        // 조합 문제인데 nC2 라서 재귀 말고 반복문으로 감
        for(int i=0; i<numbers.length; i++){
            
            for (int j=i+1; j< numbers.length; j++){
                
                st.add(numbers[i] + numbers[j]);
            }
        }    
    
        Iterator<Integer> it = st.iterator();
        int result[] = new int[st.size()];
        int idx = 0;
        
        while(it.hasNext()) result[idx++] = it.next();    
        
        
        return result;
    }
}