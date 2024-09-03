class Solution {
    public int solution(String t, String p) {
      
        int res = 0;
        int size = p.length();
        String sub;
        long p_value = Long.parseLong(p);
        
        for(int i=0;i<t.length()-size+1;i++){
            
            sub = t.substring(i,i+size);
            
            if(Long.parseLong(sub) <= p_value) res++;
        }
        
      
        
        return res;
    }
}