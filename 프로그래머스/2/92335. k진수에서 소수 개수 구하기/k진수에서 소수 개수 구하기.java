import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        String kBynaryString = Integer.toString(n, k);
        StringTokenizer stk = new StringTokenizer(kBynaryString, "0");
        System.out.println(kBynaryString);
        int res = 0;
        
        while(stk.hasMoreTokens()){
            
            String s = stk.nextToken();
            long num = Long.parseLong(s);
          System.out.println(s);
            
            if(isPrime(num)) res++;
        }
        
        return res;
    }
    
    static boolean isPrime(long n){
        
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        
        for (long i=2; i* i <= n; i++) 
            if(n % i == 0) return false;
        
        return true;
    }
    
}