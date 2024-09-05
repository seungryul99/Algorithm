import java.util.*;

class Solution {
    public StringBuffer solution(String s, int n) {    
        
        StringBuffer sb = new StringBuffer();
        
        
        for(int i=0; i<s.length(); i++){
        
            char c = s.charAt(i);
            
            
            if(c >= 'a' && c <= 'z'){
                
                c = (char)(c + n);
                if(c >'z') c = (char)(c-26);
            
            }
            else if(c >= 'A' && c <= 'Z'){
                
                c = (char)(c + n);
                if(c >'Z') c = (char)(c-26);
            }
            
            sb.append(c);
        }
        
        
        
        return sb;
    }
}