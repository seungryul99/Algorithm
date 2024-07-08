import java.util.*;

class Solution {
    public String solution(String s) {
        
        int arr[] = new int[s.length()];
        
        for(int i=0;i<s.length();i++){
            
            arr[i] = (int)s.charAt(i);
        }

        Arrays.sort(arr);
        
        StringBuffer sb = new StringBuffer();
        
        for(int i=s.length()-1;i>=0;i--){
            
            sb.append((char)arr[i]);
        }
        
        return sb.toString();
        
    }
}