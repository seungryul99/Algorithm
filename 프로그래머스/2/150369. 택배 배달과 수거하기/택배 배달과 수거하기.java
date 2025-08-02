class Solution {
    public long solution(int cap, int n, int[] d, int[] p) {
        
        long res = 0;
        int dIdx = n-1, pIdx = n-1;
        
        while(dIdx >= 0 || pIdx >= 0){
            
            while(dIdx >= 0 && d[dIdx] == 0) dIdx--;
            while(pIdx >= 0 && p[pIdx] == 0) pIdx--;
            
            // 무조건 더 큰거 까지 가야함. 가는길에 뿌리고 올 때 수거하면 됨. 
            // 택배가 많아서 수거를 못하는 경우는 없음. 
        
            int idx = dIdx > pIdx ? dIdx : pIdx;
            res += (idx+1) * 2;
            
            // 뿌림
            int cur = cap;
            for (int i=dIdx; i>=0; i--){
                
                if(d[i] >= cur) {
                    
                    d[i] -= cur;
                    cur = 0;
                    break;
                }
                else {
                    cur -= d[i];
                    d[i] = 0;
                }
            }
            
            // 수거
            cur = cap;
            for (int i=pIdx; i>=0; i--){
                
                if(p[i] >= cur) {
                    
                    p[i] -= cur;
                    cur = 0;
                    break;
                }
                else {
                    cur -= p[i];
                    p[i] = 0;
                }
            }
        }
        
        return res;
    }
}