class Solution {
    public long[] solution(int x, int n) {
        
        
        long [] res = new long[n];
        
        for (int i=0; i<n; i++) res[i] = x + (long)x*i;
        
        return res;
    }
}