import java.util.*;

class Solution {
    public int solution(int N, int number) {
       
        // dp[cnt] = {}, N cnt 개로 만들 수 있는 수의 집합
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i=0; i<=8; i++) dp.add(new HashSet<>());
        
        for (int i=1; i<=8; i++){
            
            // 이어 붙이기
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            // 사칙연산
            for (int j=1; j<i; j++){
                
                Set<Integer> st1 = dp.get(j);
                Set<Integer> st2 = dp.get(i-j);
                
                for (int x : st1){
                    
                    for(int y : st2){
                        
                        dp.get(i).add(x+y);
                        dp.get(i).add(x-y);
                        dp.get(i).add(x*y);
                        
                        if(y != 0) dp.get(i).add(x/y);
                    }
                }
            }
            
            if(dp.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}