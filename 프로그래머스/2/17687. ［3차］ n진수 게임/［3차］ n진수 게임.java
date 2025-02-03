import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
       
        int num = 0;
        int turn = 1;
        boolean end = false;
        StringBuilder sb = new StringBuilder();
        
        while(!end){
            
            String s = Integer.toString(num,n);
            
            for(int i=0; i<s.length(); i++){
                
                if(turn > m) turn -= m;
                
                if(turn == p) {
                    
                    sb.append(s.charAt(i));
                    
                    if(sb.length() == t) {
    
                        end = true;
                        break;
                    }
                }
                
                turn++;
                
            }
            num++;
        }
        
        return sb.toString().toUpperCase();
    }
}