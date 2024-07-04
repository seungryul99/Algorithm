class Solution {
    public StringBuffer solution(String s) {
        
        StringBuffer sb = new StringBuffer();
        
        if (s.length() % 2 != 0) sb.append(s.charAt(s.length()/2));
        else{
            sb.append(s.charAt(s.length()/2-1));
            sb.append(s.charAt(s.length()/2));
        }
        
        
        
        return sb;
    }
}