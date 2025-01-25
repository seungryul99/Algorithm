import java.util.*;

class Solution {
    
    public static boolean check(long num){
        
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 ==0) return false;
        
        for(long i=2; i*i <= num; i++){
            
            if(num % i ==0) return false;
        }
        
        return true;
    } 
        
    public int solution(int n, int k) {
        
        Deque<Long> dq = new ArrayDeque<>();
        int res = 0;
    
        // n -> k 진수 변환
        while (n > 0){
            
            dq.push((long)n%k);    
            n/=k;
        }
        
        // 소수체크
        
        String numStr = "";
        for(Long i : dq){
            
            if(i==0) {
                
                if(numStr == "") continue;
              
                if(check(Long.parseLong(numStr))) res++;
                  
                numStr = "";
                continue;
            }
            numStr += i;
        }
    

        if(!numStr.isBlank() && check(Long.parseLong(numStr))) res++; 
        
        return res;
    }
} 