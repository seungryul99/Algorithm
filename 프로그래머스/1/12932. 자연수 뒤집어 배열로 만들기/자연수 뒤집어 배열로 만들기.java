class Solution {
    public int[] solution(long n) {
        
        // 몇자리인지 구함
        
        String s = Long.toString(n);
        int m = s.length();
        
        int [] res = new int[m];
        
        for(int i=0;i<m;i++) res[i] = (int)s.charAt(m-1-i)-48;
       
        
        return res;
    }
}