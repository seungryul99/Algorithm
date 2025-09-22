import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        
        int num = 0, order = 1; 
        StringBuilder sb = new StringBuilder();
        
        while(true){
            
            String bs = Integer.toString(num++, n);
            
            for (int i=0; i<bs.length(); i++){
                
                if(order == p) {
                    sb.append(bs.charAt(i));
                    
                    if(sb.length() == t) return sb.toString().toUpperCase();
                }
                
                order++;
                if(order > m) order -= m;
            }
        }
        
    
    }
}