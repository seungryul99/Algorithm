import java.util.*;

class Solution {
    public StringBuffer solution(String s) {
        
        s=s.toLowerCase();
        
        StringBuffer sb = new StringBuffer(s);
        int reg = 1;
        
        
        for(int i=0;i<s.length();i++){
            
            if(reg == 1 && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                
                sb.replace(i,i+1,String.valueOf((char)(s.charAt(i) -32)));
                reg =0;
            }
            else if (reg == 1 && s.charAt(i) >= '0' && s.charAt(i) <='9') reg=0;
            else if (reg == 0 && s.charAt(i) == ' ') reg = 1; 
        }
        
        return sb;
    }
}