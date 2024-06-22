import java.util.*;

class Solution {
    public long solution(long n) {
       
        String s = Long.toString(n);
        int x = s.length();
        Integer res[] = new Integer [x];
        
        for(int i=0;i<x;i++) res[i] = (int)s.charAt(i)-48;
        
        Arrays.sort(res,Collections.reverseOrder());
        
        StringBuffer sb = new StringBuffer();
        
        for(int i=0;i<x;i++) sb.append(res[i]);
        
        return Long.parseLong(sb.toString());
    }
}