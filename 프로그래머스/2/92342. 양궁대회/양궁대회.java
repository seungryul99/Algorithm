class Solution {
    
    static int[] seq = new int[11];
    static int[] ans = new int[11];
    static int[] info;
    static int n, high = -1;
    
    public int[] solution(int num, int[] in) {
        
        n = num;
        info = in;
        
        go(0,0);
        
        return high == -1 ? new int[]{-1} : ans;
    }
    
    public void go(int idx, int cnt){
        
        if (idx == 11){
            
            if(cnt > n) return;
            if(cnt < n) seq[idx-1] = n-cnt;
            
            int a=0, r=0;
            
            for (int i=0; i<11; i++){
                
                int score = 10-i;
                
                if (seq[i] == 0 && info[i] ==0) continue;
                
                if (seq[i] > info[i]) r += score;
                else a += score;
            }
            
            
            if (r-a > 0 && r - a > high) {
                
                high = r - a;
                System.arraycopy(seq, 0, ans, 0, 11);
            }

            else if (r-a == high){
                
                for(int i= 10; i>=0; i--){
                    
                    if(seq[i] > ans[i]) {
                        System.arraycopy(seq, 0, ans, 0, 11);
                        break;
                    }
                    else if (seq[i] < ans[i]) break;
                }
            }
            
            if (cnt < n) seq[10] = 0;
            return;
        }
        
        int use = info[idx] + 1;
        
        seq[idx] += use;
        go(idx + 1, cnt + use);
        seq[idx] -= use;
        
        go(idx + 1, cnt);
    }
}